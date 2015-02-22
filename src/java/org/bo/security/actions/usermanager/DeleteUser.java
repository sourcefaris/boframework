package org.bo.security.actions.usermanager;

public class DeleteUser extends ViewUser {

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