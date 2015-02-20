package org.bo.actions.site;

import org.bo.DefaultAction;
import org.bo.entity.Site;

public class ViewSite extends DefaultAction{
	protected Site site;
	private String id = "";

	public String execute() {
		if (!id.equalsIgnoreCase(""))
		{
			site = (Site) persistence.getById(Site.class, getId());
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