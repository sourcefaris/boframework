package org.bo.actions.site;

public class DeleteSite extends SiteForm {

	public String execute() {
		if (super.execute().equalsIgnoreCase(SUCCESS)) {
		persistence.remove(site);
		return SUCCESS;
		
		} else {
			
		addActionError("Such Site couldn't be found. Removal failed");
		return ERROR;
		}
	
	}


}
