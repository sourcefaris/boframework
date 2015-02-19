package org.bo.actions.descriptor;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Descriptor;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;


@Validation
public class AddDescriptor extends DescriptorForm {
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "name", message = "Please input name"),
			@RequiredStringValidator(fieldName = "description", message = "Please input description"),
			@RequiredStringValidator(fieldName = "actionName", message = "Please input action name") })
			
	public String execute() {

		Descriptor descr = new Descriptor();
		LogInformation logInfo;

		if (hasErrors()) {
			return INPUT;
		} else {
			descr.setName(getName());
			descr.setDescription(getDescription());
			descr.setActionName(getActionName());

			LogInformation log = new LogInformation();

			/* must be fixed!!!
			 * 
			 */

			if (getCurrentUser()!= null){
				log.setCreateBy(getCurrentUser().getId());
				log.setLastUpdateBy(getCurrentUser().getId());
			}

			log.setCreateDate(new Timestamp(System.currentTimeMillis()));
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			log.setActiveFlag(LogInformation.ACTIVE);


			descr.setLogInformation(log);

			persistence.save(descr);
			
			return SUCCESS;
		}

	}

}