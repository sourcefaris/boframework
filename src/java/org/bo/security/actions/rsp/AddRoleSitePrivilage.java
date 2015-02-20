package org.bo.security.actions.rsp;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.ModuleFunction;
import org.bo.entity.RoleSite;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class AddRoleSitePrivilage extends Master {

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "mfunction.id", message = "Select Module Function"),
			@RequiredStringValidator(fieldName = "roleSite.id", message = "Select Role Site") })
	public String execute() {
		if (getMfunction().getId() != null
				&& !"".equalsIgnoreCase(getMfunction().getId())) {
			setMfunction((ModuleFunction) persistence.getById(ModuleFunction.class,
					getMfunction().getId()));
		} else {
			addFieldError("mfunction.id","Select Module Function!!");
		}
		if (getRoleSite().getId() != null
				&& !"".equalsIgnoreCase(getRoleSite().getId())) {
			setRoleSite((RoleSite) persistence.getById(RoleSite.class,
					getRoleSite().getId()));
		} else {
			addFieldError("roleSite.id", "Select Role Site!!");
		}
		if(hasErrors()){
			return INPUT;
		}
		LogInformation log = new LogInformation();
		log.setCreateBy(getCurrentUser().getId());
		log.setCreateDate(new Timestamp(System.currentTimeMillis()));
		log.setLastUpdateBy(getCurrentUser().getId());
		log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		log.setActiveFlag(1);

		getRsp().setModuleFunction(getMfunction());
		getRsp().setRoleSite(getRoleSite());
		getRsp().setSite(getRoleSite().getSite());
		getRsp().setLogInformation(log);
		persistence.save(getRsp());
		return SUCCESS;
	}

}
