package org.bo.registration;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.User;
import org.bo.persistence.PersistenceManager;

public class ConfirmChange extends DefaultAction {
	
	private User user = new User();
	private String id = "";
	private String msg = "";
	private List<User> users = new ArrayList<User>();
	private String firstName;
	
	public String execute(){
		if(!"".equals(getId())){
			user = (User) persistence.getById(User.class, getId());
		}
		return SUCCESS;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the persistence
	 */
	public PersistenceManager getManager() {
		return persistence;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}