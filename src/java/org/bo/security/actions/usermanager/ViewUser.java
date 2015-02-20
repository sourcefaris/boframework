package org.bo.security.actions.usermanager;


import org.bo.DefaultAction;
import org.bo.entity.User;

public class ViewUser extends DefaultAction {
	protected User user;
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}

	public String execute() {

		user = (User) persistence.getById(User.class, getId());
		if (user == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}