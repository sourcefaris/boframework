package org.bo.actions.modulefunction;

import java.sql.Timestamp;
import java.util.List;

import org.bo.entity.Descriptor;
import org.bo.entity.ModuleFunction;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class UpDateModuleFunction extends ModuleFunctionForm {
	private String id;
	private String moduleFunctionId = "";
	protected Descriptor moduleDescriptor = new Descriptor();
	protected ModuleFunction mf = new ModuleFunction();

	private List mfs;

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Please input name"),
			@RequiredStringValidator(fieldName = "description", message = "Please input description") })
	public String execute() {
		String result = super.execute();

		moduleFunction = (ModuleFunction) persistence.getById(ModuleFunction.class,
				getId());

		String query = "SELECT module_function FROM "
				+ ModuleFunction.class.getName()
				+ " module_function WHERE module_function.moduleFunction.id='"
				+ getId() + "'";

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

		moduleFunction.setName(getName());
		moduleFunction.setDescription(getDescription());
		moduleFunction.setModuleDescriptor(moduleDescriptor);
		moduleFunction.setModuleFunction(mf);
		moduleFunction.setSorting(getSorting());

		logInfo = moduleFunction.getLogInformation();
		logInfo.setLastUpdateBy(getCurrentUser().getId());
		logInfo.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		moduleFunction.setLogInformation(logInfo);

		persistence.save(moduleFunction);
		moduleFunctionId = moduleFunction.getId();

		mfs = persistence.getList(query);

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
}
