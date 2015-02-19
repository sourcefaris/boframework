package org.bo.actions.modulefunction;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.ModuleFunction;

public class ListModuleFunction extends DefaultAction {
	private List moduleFunctions = new ArrayList();
	protected ModuleFunction moduleFunction;
	
	public String execute(){
		moduleFunctions = persistence.getList("FROM " + ModuleFunction.class.getName()
				+ " tmp WHERE tmp.logInformation.activeFlag='"
				+ LogInformation.ACTIVE + "'");
		return SUCCESS;
	}

	/**
	 * @return Returns the moduleFunction.
	 */
	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}
	/**
	 * @param moduleFunction The moduleFunction to set.
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
	 * @param moduleFunctions The moduleFunctions to set.
	 */
	public void setModuleFunctions(List moduleFunctions) {
		this.moduleFunctions = moduleFunctions;
	}
}
