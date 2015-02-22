package org.bo.security.actions.usermanager;

public class DeleteUser extends UserForm {

	public String execute() {

		String result = super.execute();

		if (result.equalsIgnoreCase(SUCCESS)) {

			persistence.remove(getUser());
			return SUCCESS;
		} else {
			addActionError("Cannot find such Descriptor");
			return ERROR;
		}
	}
}