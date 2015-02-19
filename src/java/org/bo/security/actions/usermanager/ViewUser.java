package org.bo.security.actions.usermanager;


import org.bo.entity.User;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;

import com.opensymphony.xwork2.ActionSupport;

public class ViewUser extends ActionSupport implements PersistenceAware {

	protected PersistenceManager pm;
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
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.pm = persistenceManager;
	}

	public String execute() {

		user = (User) pm.getById(User.class, getId());
		if (user == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}