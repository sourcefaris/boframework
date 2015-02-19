package org.bo.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.bo.entity.User;
import org.bo.util.StringUtils;

public class HttpSessionCredentials implements SessionCredentials,
		UserAccessorAware {

	private UserAccessor userAccessor;

	public void setUserAccessor(UserAccessor userAccessor) {
		this.userAccessor = userAccessor;
	}

	public User getCurrentUser() {
		StringUtils stringUtils = new StringUtils();

		String remoteUser = getRequest().getRemoteUser();

		String userId = "";

		if (ServletActionContext.getRequest().getSession().getAttribute(
				LoginFilter.LOGIN_GA_USER) != null) {
			userId = stringUtils.decodeBase64(""
					+ ServletActionContext.getRequest().getSession()
							.getAttribute(LoginFilter.LOGIN_GA_USER));
		}

		if (userId.equalsIgnoreCase("")) {
			return null;
		} else {
			return userAccessor.getById(userId);
			//return null;
		}
	}

	private HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
}