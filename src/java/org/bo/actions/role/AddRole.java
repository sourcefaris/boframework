package org.bo.actions.role;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Role;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;


@Validation
public class AddRole extends RoleForm{
	Role role = new Role();

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Name can't be empty."),
			@RequiredStringValidator(fieldName = "description", message = "Description can't be empty.") 
			})
	public String execute() {
		
		if (hasErrors()) {
			return INPUT;
		 } else {
		 		
			role.setName(getName());
			role.setDescription(getDescription());
			

			// logging information
			LogInformation log = new LogInformation();
			
			if (getCurrentUser() != null ) {
				log.setCreateBy(getCurrentUser().getId());
				log.setLastUpdateBy(getCurrentUser().getId());
				
			}
			
			log.setCreateDate(new Timestamp(System.currentTimeMillis()));
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			log.setActiveFlag(LogInformation.ACTIVE);

			role.setLogInformation(log);
			persistence.save(role);
			return SUCCESS;
		} 
	}
	
	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return role;
	}


}