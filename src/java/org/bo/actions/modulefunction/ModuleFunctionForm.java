package org.bo.actions.modulefunction;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.Descriptor;
import org.bo.entity.ModuleFunction;
import org.bo.entity.User;

public class ModuleFunctionForm extends DefaultAction{
	protected ModuleFunction moduleFunction;
	protected LogInformation logInfo;
	private User user = new User();
	
	private String name="";
	private String description="";
	private String tableReferences="";
	private String moduleFunctionId="";
	
	private String moduleDescriptorId="";
	private List<Descriptor> moduleDescriptors = new ArrayList<Descriptor>();
	
	public String execute(){
		user = (User) persistence.getById(User.class, getCurrentUser().getId());
		return SUCCESS;
	}
	
	/**
	 * @return Returns the moduleFunctionId.
	 */
	public String getModuleFunctionId() {
		return moduleFunctionId;
	}
	/**
	 * @param moduleFunctionId The moduleFunctionId to set.
	 */
	public void setModuleFunctionId(String moduleFunctionId) {
		this.moduleFunctionId = moduleFunctionId;
	}
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return Returns the logInfo.
	 */
	public LogInformation getLogInfo() {
		return logInfo;
	}
	/**
	 * @param logInfo The logInfo to set.
	 */
	public void setLogInfo(LogInformation logInfo) {
		this.logInfo = logInfo;
	}
	
	/**
	 * @return Returns the moduleDescriptorId.
	 */
	public String getModuleDescriptorId() {
		return moduleDescriptorId;
	}
	/**
	 * @param moduleDescriptorId The moduleDescriptorId to set.
	 */
	public void setModuleDescriptorId(String moduleDescriptorId) {
		this.moduleDescriptorId = moduleDescriptorId;
	}
	/**
	 * @return Returns the moduleDescriptors.
	 */
	public List getModuleDescriptors() {
		return moduleDescriptors;
	}
	/**
	 * @param moduleDescriptors The moduleDescriptors to set.
	 */
	public void setModuleDescriptors(List moduleDescriptors) {
		this.moduleDescriptors = moduleDescriptors;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the tableReferences.
	 */
	public String getTableReferences() {
		return tableReferences;
	}
	/**
	 * @param tableReferences The tableReferences to set.
	 */
	public void setTableReferences(String tableReferences) {
		this.tableReferences = tableReferences;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
