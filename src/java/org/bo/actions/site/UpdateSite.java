package org.bo.actions.site;

import java.sql.Timestamp;

import org.bo.entity.Site;
import org.bo.security.SessionCredentials;
import org.bo.security.SessionCredentialsAware;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class UpdateSite extends SiteForm implements SessionCredentialsAware {

	private SessionCredentials sess;
	private String id;
	private Site site;

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Name can't be empty."),
			@RequiredStringValidator(fieldName = "description", message = "Description can't be empty.") })
	public String execute() {
		if (hasErrors()) {
			return INPUT;
		} else {
			site = (Site) persistenceManager.getById(Site.class, getId());

			site.setName(getName());
			site.setDescription(getDescription());
			site.setTitle(getTitle());
			site.setAdmin_email(getAdmin_email());
			site.setNotify_email(getNotify_email());
			site.setNotify_flag(getNotify_flag());
			site.setNotify_from(getNotify_from());
			site.setNotify_message(getNotify_message());
			site.setUrl_branding(getUrl_branding());
			site.setSite_url(getSite_url());
			logInfo = site.getLogInformation();
			logInfo.setLastUpdateBy(sess.getCurrentUser().getId());
			logInfo.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			site.setLogInformation(logInfo);
			persistenceManager.save(site);
			return SUCCESS;
		}
	}

	public void setSessionCredentials(SessionCredentials sessionCredentials) {
		this.sess = sessionCredentials;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

}
