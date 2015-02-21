package org.bo.security.login;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.GenerateMenu;
import org.bo.entity.Role;
import org.bo.entity.RoleSite;
import org.bo.entity.Site;
import org.bo.entity.User;
import org.bo.security.LoginFilter;
import org.bo.security.UserAccessor;
import org.bo.security.UserAccessorAware;
import org.bo.util.StringUtils;

import com.opensymphony.xwork2.ActionContext;

public class LoginForm extends DefaultAction implements UserAccessorAware {
	protected UserAccessor ua;
	protected StringUtils su = new StringUtils();
	private String username = "";
	private String password = "";
	private User user = new User();
	private Site site = new Site();
	private Role role = new Role();
	private List<User> users = new ArrayList<User>();
	private String redirectUri;
	List<RoleSite> roleSites = new ArrayList<RoleSite>();

	public String execute() {
		GenerateMenu.run();
		if (ActionContext.getContext().getSession().get(
				LoginFilter.LOGIN_GA_USER) != null) { // sudah login
			
			getUser().setId(su.decodeBase64(ActionContext.getContext().getSession().get(LoginFilter.LOGIN_GA_USER).toString()));
			setUser(ua.getById(getUser().getId()));
			String sql = "FROM "+RoleSite.class.getName()+" rs WHERE rs.role.id ='"+getUser().getRole().getId()+"' ";
			roleSites = persistence.getList(sql);
			if(roleSites.size()>1) return "site";
			else if (roleSites.size()==1){
				setSite(roleSites.get(0).getSite());
				return "continue";
			} else return "continue";
		} else { // belum login
			return "login";
		}
	}

	public void setUserAccessor(UserAccessor ua) {
		this.ua = ua;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StringUtils getSu() {
		return su;
	}

	public void setSu(StringUtils su) {
		this.su = su;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}


	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	public boolean getAllowRegister(){
		return Boolean.getBoolean(get("application.registration.public"));
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<RoleSite> getRoleSites() {
		return roleSites;
	}
	
	public void setRoleSites(List<RoleSite> roleSites) {
		this.roleSites = roleSites;
	}
	
}
