package org.bo.actions.site;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Site;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class AddSite extends SiteForm {

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Name can't be empty."),
			@RequiredStringValidator(fieldName = "description", message = "Description can't be empty.") })
	public String execute() {
		//
		// if (getName().equalsIgnoreCase("")) {
		// addActionError("Name can't be empty.");
		// }

		if (hasErrors()) {
			return INPUT;
		} else {
			Site newSite = new Site();

			newSite.setName(getName());
			newSite.setTitle(getTitle());
			newSite.setDescription(getDescription());
			newSite.setUrl_branding(getUrl_branding());
			newSite.setSite_url(getSite_url());
			newSite.setAdmin_email(getAdmin_email());
			newSite.setNotify_flag(getNotify_flag());
			newSite.setNotify_email(getNotify_email());
			newSite.setNotify_from(getNotify_from());
			newSite.setNotify_message(getNotify_message());
			
			
			// newSite.setSite_headline(getSite_headline());

			LogInformation log = new LogInformation();

			if (getCurrentUser() != null) {
				log.setCreateBy(getCurrentUser().getId());
				log.setLastUpdateBy(getCurrentUser().getId());
			}

			log.setCreateDate(new Timestamp(System.currentTimeMillis()));
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			log.setActiveFlag(LogInformation.ACTIVE);

			newSite.setLogInformation(log);
			persistence.save(newSite);

			return SUCCESS;
		}

	}

}