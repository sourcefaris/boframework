package org.bo;

import java.io.IOException;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.URLBean;
import org.bo.entity.Role;
import org.bo.entity.User;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;
import org.bo.security.SessionCredentials;
import org.bo.security.SessionCredentialsAware;
import org.bo.util.PropertyLooker;

import com.opensymphony.xwork2.ActionSupport;


public class DefaultAction extends ActionSupport implements PersistenceAware, SessionCredentialsAware {
	protected PersistenceManager persistence;
	private SessionCredentials sessionCredentials;
	private String currDescriptor;
	
	private static Properties properties = new Properties();
	static {
		try {
			properties.load(PropertyLooker.getResourceAsStream("conf.properties"));
		} catch (IOException e){
			e.printStackTrace();
		} catch (NullPointerException npe) {
			LOG.info("file conf.properties is not in classpath");
			npe.printStackTrace();
		}
	}
	public static String getCurrDescriptorUrl(){
		URLBean bean = new URLBean();
		bean.setRequest(ServletActionContext.getRequest());
		bean.setResponse(ServletActionContext.getResponse());
		String target = ServletActionContext.getResponse().encodeRedirectURL(bean.toString());
		
		String descriptorCandidate[] = target.split("/");
		String descriptorName = descriptorCandidate[3];
		return descriptorName;
	}
	public static String get(String propertyName){
		return properties.getProperty(propertyName);
	}
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistence = persistenceManager;
	}
	public void setSessionCredentials(SessionCredentials sessionCredentials) {
		this.sessionCredentials = sessionCredentials;
	}
	
	public User getCurrentUser(){
		return sessionCredentials.getCurrentUser();
	}
	public Role getCurrentRole(){
		return getCurrentUser().getRole();
	}
	public String getCurrDescriptor() {
		return currDescriptor;
	}
	public void setCurrDescriptor(String currDescriptor) {
		this.currDescriptor = currDescriptor;
	}
	public String getLogo(){
		return get("application.logo.url");
	}
}
