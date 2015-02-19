package org.bo.actions.descriptor;

public class DeleteDescriptor extends ViewDescriptor {

	public String execute() {

		String result = super.execute();

		if (result.equalsIgnoreCase(SUCCESS)) {
			
			persistence.remove(descriptor);
			return SUCCESS;
		} else {
			addActionError("Cannot find such Descriptor");
			return ERROR;
		}
	}
}