package org.bo.actions.modulefunction;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.ModuleFunction;

public class ListModulePrivilage extends DefaultAction {
	protected ModuleFunction moduleFunction;
	protected List moduleFunctions = new ArrayList();

	public String execute() {
		String query = "FROM "
				+ ModuleFunction.class.getName()
				+ " mf WHERE mf.moduleFunction.id='0' AND mf.logInformation.activeFlag='"
				+ LogInformation.ACTIVE + "'";

		moduleFunctions = persistence.getList(query);
		return SUCCESS;

	}

	/**
	 * @return Returns the moduleFunction.
	 */
	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}

	/**
	 * @param moduleFunction
	 *            The moduleFunction to set.
	 */
	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}

	/**
	 * @return Returns the moduleFunctions.
	 */
	public List getModuleFunctions() {
		return moduleFunctions;
	}

	/**
	 * @param moduleFunctions
	 *            The moduleFunctions to set.
	 */
	public void setModuleFunctions(List moduleFunctions) {
		this.moduleFunctions = moduleFunctions;
	}
}
