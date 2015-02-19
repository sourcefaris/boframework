package org.bo.actions.site;

import org.bo.entity.Site;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;

import com.opensymphony.xwork2.ActionSupport;

public class ViewSite extends ActionSupport implements PersistenceAware {

	protected PersistenceManager pm;
	protected Site site;
	private String id = "";

	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.pm = persistenceManager;

	}

	public String execute() {
		if (!id.equalsIgnoreCase(""))
		{
			site = (Site) pm.getById(Site.class, getId());
			return SUCCESS;
		}
		else
		{
			addActionError("Site not found");
			return ERROR;
		}
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Site getSite() {
		return site;
	}

	public String getId() {
		return id;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
}