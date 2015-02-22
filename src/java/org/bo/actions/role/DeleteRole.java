package org.bo.actions.role;

public class DeleteRole extends RoleForm {

	public String execute() {
		if (super.execute().equalsIgnoreCase(SUCCESS)) {
			persistence.remove(getRole());
			return SUCCESS;

		} else {
			addActionError("Such Role couldn't be found. Removal failed");
			return ERROR;
		}

	}

}
