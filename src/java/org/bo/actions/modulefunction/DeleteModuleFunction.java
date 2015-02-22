package org.bo.actions.modulefunction;

import org.bo.entity.ModuleFunction;


public class DeleteModuleFunction extends ModuleFunctionForm {
	public String execute() {
		String result = super.execute();

		if (result.equalsIgnoreCase(SUCCESS)) {
			moduleFunction = (ModuleFunction) persistence.getById(
					ModuleFunction.class, moduleFunction.getId());
			persistence.remove(moduleFunction);
			return SUCCESS;

		} else {
			addActionError("No Module Function");
			return INPUT;
		}

	}
}
