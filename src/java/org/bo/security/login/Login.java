package org.bo.security.login;

import org.bo.security.LoginFilter;
import org.bo.security.UserAccessorAware;

import com.opensymphony.xwork2.ActionContext;

public class Login extends LoginForm implements UserAccessorAware {
    
    public String execute() {
    	if (ua.authenticate(getUsername(), getPassword())) {
    		setUser(ua.getByUsername(getUsername()));
    		if(getUser().getRole().getName().equalsIgnoreCase("default")){
    			addFieldError("username", "Sorry, your account not activated yet.");
    			return INPUT;
    		} else {
	            ActionContext.getContext().getSession().put(LoginFilter.LOGIN_GA_USER, su.encodeBase64(getUser().getId()));
	            
	            /* Normal flow */
	            return SUCCESS;
    		}
        } else {
            addFieldError("username", "Invalid username or password.");
            return INPUT;
        }
    }

    
}