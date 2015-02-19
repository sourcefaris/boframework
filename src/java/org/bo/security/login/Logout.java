package org.bo.security.login;

import org.bo.security.LoginFilter;

import com.opensymphony.xwork2.ActionContext;

public class Logout extends LoginForm {

    public String execute() {
        ActionContext.getContext().getSession().remove(LoginFilter.LOGIN_GA_USER);
        ActionContext.getContext().getSession().remove(LoginFilter.LOGIN_GS_SITE);
        return SUCCESS;
    }

}
