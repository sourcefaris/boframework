package org.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

@Entity()
@Table(name = "company")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Company extends DefaultPersistence {

	private String name = "";
	private String address = "";
	private String state = "";
	private String zip_number = "";
	private String telephone = "";
	private String faximile = "";
	private String website = "";
	private String email = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "faximile")
	public String getFaximile() {
		return faximile;
	}

	public void setFaximile(String faximile) {
		this.faximile = faximile;
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

}
