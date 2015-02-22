package org.bo.security.actions.usermanager;

import org.bo.DefaultAction;
import org.bo.entity.Company;
import org.bo.entity.Role;
import org.bo.entity.User;
import org.bo.security.Address;
import org.bo.security.Name;

public class UserForm extends DefaultAction {
	private User user = new User();
	private Address address = new Address();
	private Name name = new Name();
	private Company company = new Company();
	private Role role = new Role();
	private String id;

	public String execute() {
		if(getId()!=null && !"".equalsIgnoreCase(getId().trim()))
			user = (User) persistence.getById(User.class, getId());
		return SUCCESS;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

}
