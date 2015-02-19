package org.bo.security.actions.usermanager;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.Company;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;

import com.opensymphony.xwork2.ActionSupport;

public class ViewListCompany extends DefaultAction{
	private List perusahaan = new ArrayList();
	protected Company company;
	
	public String execute(){
		perusahaan = persistence.findAllSorted(Company.class, "name");
		return SUCCESS;
	}

	/**
	 * @return the perusahaan
	 */
	public List getPerusahaan() {
		return perusahaan;
	}

	/**
	 * @param perusahaan the perusahaan to set
	 */
	public void setPerusahaan(List perusahaan) {
		this.perusahaan = perusahaan;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;

	}
}
	
	