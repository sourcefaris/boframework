package org.bo.actions.role;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Role;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class EditRole extends RoleForm {

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Name can't be empty."),
			@RequiredStringValidator(fieldName = "description", message = "Description can't be empty.") })
	public String execute() {

		Role role = (Role) persistence.getById(Role.class, getId());
		if (role == null) {
			addActionError("Such role couldn't be found. Edit process failed.");
			return ERROR;
		}

		else {
			if (getName().equalsIgnoreCase(""))
				addActionError("Name can't be empty.");
			if (getDescription().equalsIgnoreCase(""))
				addActionError("Description can't be empty.");
			if (hasErrors()) {
				return INPUT;
			} else {

				role.setName(getName());
				role.setDescription(getDescription());

				LogInformation log = role.getLogInformation();
				
				if (getCurrentUser()!= null) {
				log.setLastUpdateBy(getCurrentUser().getId());}
				log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
				role.setLogInformation(log);
				persistence.save(role);
				return SUCCESS;
			}
		}
	}
}