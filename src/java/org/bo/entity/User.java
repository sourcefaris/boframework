package org.bo.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bo.DefaultPersistence;
import org.bo.security.Address;
import org.bo.security.Name;
/**
 * A very simple user. 
 */
@Entity()
@Table(name="backend_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User extends DefaultPersistence {
	private String username;
	private String password;
	private Name name = new Name();
	private Address address = new Address();
	private Company company;
	private Role role;
	private String email;
	private String description;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Password of user 
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	@Embedded
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * 
	 */
	@Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne
	@JoinColumn(name="company_id")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}