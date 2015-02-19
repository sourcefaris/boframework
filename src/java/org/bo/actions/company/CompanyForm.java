package org.bo.actions.company;

import org.bo.DefaultAction;
import org.bo.entity.User;


public class CompanyForm extends DefaultAction {
	private User user = new User();
	private String id;
	private String name="";
	private String address="";
	private String state="";
	private String zip_number="";
	private String telephone="";
	private String faximile="";
	private String website="";
	private String email="";
	
	public String execute(){
		user = (User) persistence.getById(User.class, getCurrentUser().getId());
		return SUCCESS;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}





	public String getFaximile() {
		return faximile;
	}





	public void setFaximile(String faximile) {
		this.faximile = faximile;
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public String getTelephone() {
		return telephone;
	}





	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}





	public String getWebsite() {
		return website;
	}





	public void setWebsite(String website) {
		this.website = website;
	}





	public String getZip_number() {
		return zip_number;
	}





	public void setZip_number(String zip_number) {
		this.zip_number = zip_number;
	}





	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}