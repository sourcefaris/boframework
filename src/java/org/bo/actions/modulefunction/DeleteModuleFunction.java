/*
 * Created on Jul 4, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.bo.actions.modulefunction;

import org.bo.entity.ModuleFunction;


public class DeleteModuleFunction extends ViewModuleFunction {
	public String execute() {
		String result = super.execute();

		if (result.equalsIgnoreCase(SUCCESS)) {
			ModuleFunction mf = moduleFunction.getModuleFunction();
			if (mf != null) {
				mf.getModuleFunctions().remove(moduleFunction);
				moduleFunction.setModuleFunction(null);
				persistence.save(mf);
			}
			persistence.save(moduleFunction);
			moduleFunction = (ModuleFunction) persistence.getById(
					ModuleFunction.class, moduleFunction.getId());
			for (ModuleFunction m : moduleFunction.getModuleFunctions()) {
				m.setModuleFunction(null);
				persistence.save(m);
			}
			persistence.remove(moduleFunction);
			return SUCCESS;

		} else {
			addActionError("No Module Function");
			return INPUT;
		}

	}
}
