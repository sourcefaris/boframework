package org.bo.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class SecurityHttpRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public SecurityHttpRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    public String getRemoteUser() {
        String user = (String) request.getSession().getAttribute(LoginFilter.LOGIN_KEY);
        return user;
    }

    public Principal getUserPrincipal() {
        final String name = getRemoteUser();

        return new Principal() {
            public String getName() {
                return name;
            }
        };
    }
}
