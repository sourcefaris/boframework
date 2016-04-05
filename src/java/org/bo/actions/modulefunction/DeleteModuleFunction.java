package org.bo.actions.modulefunction;

import org.bo.entity.ModuleFunction;

public class DeleteModuleFunction extends ModuleFunctionForm {
	@Override
	public String execute() {
		String result = super.execute();
		if (result.equalsIgnoreCase(SUCCESS)) {
			ModuleFunction mf = getModuleFunction().getModuleFunction();
			if (mf != null) {
				mf.getModuleFunctions().remove(getModuleFunction());
				getModuleFunction().setModuleFunction(null);
				persistence.save(mf);
			}
			persistence.save(getModuleFunction());
			setModuleFunction((ModuleFunction) persistence.getById(
					ModuleFunction.class, getModuleFunction().getId()));
			for (ModuleFunction m : getModuleFunction().getModuleFunctions()) {
				m.setModuleFunction(null);
				persistence.save(m);
			}
			persistence.remove(getModuleFunction());
			return SUCCESS;
		} else {
			addActionError("Cannot find such ModuleFunction");
			return ERROR;
		}
	}
}
