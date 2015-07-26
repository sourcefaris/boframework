package org.bo.actions.modulefunction;

public class DeleteModuleFunction extends ModuleFunctionForm {
	
	public String execute() {
		if (super.execute().equalsIgnoreCase(SUCCESS)) {
			persistence.remove(getModuleFunction());
			return SUCCESS;

		} else {
			addActionError("No Module Function");
			return INPUT;
		}

	}
}
