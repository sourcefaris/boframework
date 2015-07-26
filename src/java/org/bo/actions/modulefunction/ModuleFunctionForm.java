package org.bo.actions.modulefunction;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.Descriptor;
import org.bo.entity.ModuleFunction;

public class ModuleFunctionForm extends DefaultAction {
	protected ModuleFunction moduleFunction;
	protected LogInformation logInfo;

	private String id;
	private String name = "";
	private String description = "";
	private String moduleFunctionId = "";
	private int sorting;

	private String moduleDescriptorId = "";
	private List<Descriptor> moduleDescriptors = new ArrayList<Descriptor>();
	private List<ModuleFunction> mfs;

	public String execute() {
		if (getId() != null && !"".equalsIgnoreCase(getId().trim())) {
			moduleFunction = (ModuleFunction) persistence.getById(
					ModuleFunction.class, getId());
			mfs = moduleFunction.getModuleFunctions();
		}
		return SUCCESS;
	}

	public String getModuleFunctionId() {
		return moduleFunctionId;
	}

	public void setModuleFunctionId(String moduleFunctionId) {
		this.moduleFunctionId = moduleFunctionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LogInformation getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(LogInformation logInfo) {
		this.logInfo = logInfo;
	}

	public String getModuleDescriptorId() {
		return moduleDescriptorId;
	}

	public void setModuleDescriptorId(String moduleDescriptorId) {
		this.moduleDescriptorId = moduleDescriptorId;
	}

	public List getModuleDescriptors() {
		return moduleDescriptors;
	}

	public void setModuleDescriptors(List moduleDescriptors) {
		this.moduleDescriptors = moduleDescriptors;
	}

	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}

	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ModuleFunction> getMfs() {
		return mfs;
	}
	
	public int getSorting() {
		return sorting;
	}
	
	public void setSorting(int sorting) {
		this.sorting = sorting;
	}

}
