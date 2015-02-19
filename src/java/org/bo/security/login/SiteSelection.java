package org.bo.security.login;

import org.bo.security.LoginFilter;

import com.opensymphony.xwork2.ActionContext;

public class SiteSelection extends LoginForm {
	public String execute(){
		if(getSite().getId() != null || !"".equalsIgnoreCase(getSite().getId())){
			ActionContext.getContext().getSession().put(LoginFilter.LOGIN_GS_SITE, getSite().getId());
		} else {
			return INPUT;
		}
		return SUCCESS;
	}
}
