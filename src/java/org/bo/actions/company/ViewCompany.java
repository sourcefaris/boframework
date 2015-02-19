package org.bo.actions.company;

import org.bo.DefaultAction;
import org.bo.entity.Company;

public class ViewCompany extends DefaultAction{
	protected Company company;
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}

	public String execute() {

		company = (Company) persistence.getById(Company.class, getId());
		if (company == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}