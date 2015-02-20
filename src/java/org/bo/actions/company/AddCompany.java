package org.bo.actions.company;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Company;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validation
public class AddCompany extends CompanyForm {

	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "name", message = "Name can't be empty") })
	public String execute() {

		Company comp = new Company();

		if (hasErrors()) {
			return INPUT;

		} else {

			comp.setName(getName());
			comp.setAddress(getAddress());
			comp.setState(getState());
			comp.setZip_number(getZip_number());

			comp.setTelephone(getTelephone());
			comp.setFaximile(getFaximile());
			comp.setWebsite(getWebsite());
			comp.setEmail(getEmail());

			LogInformation log = new LogInformation();

			/*
			 * must be fixed!!!
			 * 
			 */

			if (getCurrentUser() != null) {
				log.setCreateBy(getCurrentUser().getId());
				log.setLastUpdateBy(getCurrentUser().getId());
			}

			log.setCreateDate(new Timestamp(System.currentTimeMillis()));
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));

			comp.setLogInformation(log);

			persistence.save(comp);
			return SUCCESS;
		}

	}

}