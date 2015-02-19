
package org.bo.security.actions.usermanager;

import org.bo.DefaultAction;
import org.bo.entity.Company;
import org.bo.entity.Role;
import org.bo.entity.User;
import org.bo.security.Address;
import org.bo.security.Name;

public class UserForm extends DefaultAction{
	private User user = new User();
	private User currUser = new User();
	private Address address = new Address();
	private Name name = new Name();
	private Company company = new Company();
	private Role role = new Role();
	
	public String execute(){
		if(getUser().getId() != null && !"".equalsIgnoreCase(getUser().getId())){
			setUser((User) persistence.getById(User.class, getUser().getId()));
		}
		currUser = (User) persistence.getById(User.class, getCurrentUser().getId());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	/**
	 * @return the userFlat
	 */
	public User getCurrUser() {
		return currUser;
	}

	/**
	 * @param userFlat the userFlat to set
	 */
	public void setCurrUser(User userFlat) {
		this.currUser = userFlat;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
