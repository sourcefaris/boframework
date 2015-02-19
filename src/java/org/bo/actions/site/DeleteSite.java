package org.bo.actions.site;

public class DeleteSite extends ViewSite {

	public String execute() {
		if (super.execute().equalsIgnoreCase(SUCCESS)) {
		pm.remove(site);
		return SUCCESS;
		
		} else {
			
		addActionError("Such Site couldn't be found. Removal failed");
		return ERROR;
		}
	
	}


}
