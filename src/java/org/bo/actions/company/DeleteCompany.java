package org.bo.actions.company;

public class DeleteCompany extends CompanyForm {

	public String execute() {

		String result = super.execute();

		if (result.equalsIgnoreCase(SUCCESS)) {

			persistence.remove(company);
			return SUCCESS;
		} else {
			addActionError("Cannot find such Descriptor");
			return ERROR;
		}
	}
}