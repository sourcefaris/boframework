package org.bo.actions.modulefunction;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Descriptor;
import org.bo.entity.ModuleFunction;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class AddModuleFunction extends ModuleFunctionForm {
	private String id = "";
	protected Descriptor moduleDescriptor = new Descriptor();
	private String moduleDescriptorId = "";
	private String moduleFunctionId = "";
	protected ModuleFunction mf = new ModuleFunction();

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Please input name"),
			@RequiredStringValidator(fieldName = "description", message = "Please input description") })
	public String execute() {
		if (hasErrors()){
			return INPUT;
		}
		if (getModuleDescriptorId() != null
				&& !"".equalsIgnoreCase(getModuleDescriptorId())) {
			moduleDescriptor = (Descriptor) persistence.getById(Descriptor.class,
					getModuleDescriptorId());
		} else {
			moduleDescriptor = null;
		}
		if (getModuleFunctionId() != null
				&& !"".equalsIgnoreCase(getModuleFunctionId())) {
			mf = (ModuleFunction) persistence.getById(ModuleFunction.class,
					getModuleFunctionId());
		} else {
			mf = null;
		}

		moduleFunction = new ModuleFunction();
		moduleFunction.setName(getName());
		moduleFunction.setDescription(getDescription());
		moduleFunction.setModuleDescriptor(moduleDescriptor);
		moduleFunction.setModuleFunction(mf);

		logInfo = new LogInformation();
		logInfo.setCreateBy(getCurrentUser().getId());
		logInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
		logInfo.setLastUpdateBy(getCurrentUser().getId());
		logInfo.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		logInfo.setActiveFlag(LogInformation.ACTIVE);
		moduleFunction.setLogInformation(logInfo);

		persistence.save(moduleFunction);
		moduleFunctionId = moduleFunction.getId();
		return SUCCESS;
	}

	/**
	 * @return Returns the moduleFunctionId.
	 */
	public String getModuleFunctionId() {
		return moduleFunctionId;
	}

	/**
	 * @param moduleFunctionId
	 *            The moduleFunctionId to set.
	 */
	public void setModuleFunctionId(String moduleFunctionId) {
		this.moduleFunctionId = moduleFunctionId;
	}

	/**
	 * @return Returns the moduleDescriptorId.
	 */
	public String getModuleDescriptorId() {
		return moduleDescriptorId;
	}

	/**
	 * @param moduleDescriptorId
	 *            The moduleDescriptorId to set.
	 */
	public void setModuleDescriptorId(String moduleDescriptorId) {
		this.moduleDescriptorId = moduleDescriptorId;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the moduleDescriptor.
	 */
	public Descriptor getModuleDescriptor() {
		return moduleDescriptor;
	}

	/**
	 * @param moduleDescriptor
	 *            The moduleDescriptor to set.
	 */
	public void setModuleDescriptor(Descriptor moduleDescriptor) {
		this.moduleDescriptor = moduleDescriptor;
	}
}
