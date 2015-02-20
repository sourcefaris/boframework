package org.bo.password;

import org.bo.DefaultAction;
import org.bo.entity.User;


public class PasswordForm extends DefaultAction{
	private String id = "";
	private String msg = "";
	private String currPassword = "";
	private String newPassword = "";
	private String verifyPassword = "";
	User user = new User();
	
	public String execute(){
		if(getCurrentUser() != null){
			user = getCurrentUser();
		}
		return SUCCESS;
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	/**
	 * @return the currPassword
	 */
	public String getCurrPassword() {
		return currPassword;
	}
	/**
	 * @param currPassword the currPassword to set
	 */
	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}
}
