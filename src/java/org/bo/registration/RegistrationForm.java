package org.bo.registration;

import org.bo.DefaultAction;
import org.bo.entity.User;

public class RegistrationForm extends DefaultAction {
	private User user = new User();
	
	public String execute(){
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
