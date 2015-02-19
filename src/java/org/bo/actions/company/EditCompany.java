package org.bo.actions.company;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Company;
import org.bo.security.SessionCredentials;
import org.bo.security.SessionCredentialsAware;

public class EditCompany extends CompanyForm {

	private SessionCredentials sessCredentials;

	public String execute() {
		System.out.println("UPDATE");
		Company comp = (Company) persistence.getById(Company.class, getId());

		if (comp == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;

		} else {

			if (getName().equalsIgnoreCase("")) {
				addActionError("Name can't be empty");
			}
			

			comp.setName(getName());
			comp.setAddress(getAddress());
			comp.setState(getState());
			comp.setZip_number(getZip_number());
	
		    comp.setTelephone(getTelephone());
			comp.setFaximile(getFaximile());
			comp.setWebsite(getWebsite());
			comp.setEmail(getEmail());

			LogInformation log = comp.getLogInformation();
			
			if (sessCredentials.getCurrentUser()!=null) {
			log.setLastUpdateBy(sessCredentials.getCurrentUser().getId());
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			}

			

			comp.setLogInformation(log);

			if (hasErrors()) {
				return INPUT;
			} else {
				persistence.save(comp);
				return SUCCESS;
			}
		}

	}

	public void setSessionCredentials(SessionCredentials sessionCredentials) {
		this.sessCredentials = sessionCredentials;

	}

}