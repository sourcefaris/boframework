package org.bo.password;

import org.bo.entity.User;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;
import org.bo.security.SessionCredentials;
import org.bo.security.SessionCredentialsAware;

import com.opensymphony.xwork2.ActionSupport;


public class PasswordForm extends ActionSupport implements PersistenceAware, SessionCredentialsAware{
	private PersistenceManager manager;
	private String id = "";
	private String msg = "";
	private String currPassword = "";
	private String newPassword = "";
	private String verifyPassword = "";
	protected SessionCredentials sess;
	User user = new User();
	
	public String execute(){
		if(sess.getCurrentUser() != null){
			user = sess.getCurrentUser();
		}
		return SUCCESS;
	}
	public void setSessionCredentials(SessionCredentials sessionCredentials) {
		this.sess = sessionCredentials;
	}

	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.manager = persistenceManager;
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

	/**
	 * @return the persistence
	 */
	public PersistenceManager getManager() {
		return manager;
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
