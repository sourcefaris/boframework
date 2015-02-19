package org.bo.security.actions.rsp;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.ModuleFunction;
import org.bo.entity.Role;
import org.bo.entity.RoleSite;
import org.bo.entity.RoleSitePrivilage;

public class Master extends DefaultAction {
	private Role role = new Role();
	private RoleSite roleSite = new RoleSite();
	private ModuleFunction mfunction = new ModuleFunction();
	private RoleSitePrivilage rsp = new RoleSitePrivilage();
	private List<RoleSitePrivilage> rsps = new ArrayList<RoleSitePrivilage>();
	private List<RoleSite> roleSites = new ArrayList<RoleSite>();
	private List<Role> roles = new ArrayList<Role>();

	public RoleSitePrivilage getRsp() {
		return rsp;
	}

	public void setRsp(RoleSitePrivilage rsp) {
		this.rsp = rsp;
	}

	public String execute() {
		if (getRole().getId() != null
				&& !"".equalsIgnoreCase(getRole().getId())) {
			setRole((Role) persistence.getById(Role.class, getRole().getId()));
			setRoleSites(persistence.getList("FROM " + RoleSite.class.getName()
					+ " rs " + "WHERE rs.role.id='" + getRole().getId() + "' "
					+ "AND rs.logInformation.activeFlag=1"));
		}
		if (getRoleSite().getId() != null
				&& !"".equalsIgnoreCase(getRoleSite().getId())) {
			setRoleSite((RoleSite) persistence.getById(RoleSite.class,
					getRoleSite().getId()));
			setRsps(persistence.getList("FROM " + RoleSitePrivilage.class.getName()
					+ " rsp " + "WHERE rsp.roleSite.id='"
					+ getRoleSite().getId() + "' "
					+ "AND rsp.logInformation.activeFlag=1"));
		}
		setRoles(persistence.getList("FROM " + Role.class.getName()
				+ " tmp " + "WHERE tmp.logInformation.activeFlag=1"));
		return SUCCESS;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleSite getRoleSite() {
		return roleSite;
	}

	public void setRoleSite(RoleSite SiteroleSite) {
		this.roleSite = SiteroleSite;
	}

	public List<RoleSite> getRoleSites() {
		return roleSites;
	}

	public void setRoleSites(List<RoleSite> roleSites) {
		this.roleSites = roleSites;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<RoleSitePrivilage> getRsps() {
		return rsps;
	}

	public void setRsps(List<RoleSitePrivilage> rsps) {
		this.rsps = rsps;
	}

	public ModuleFunction getMfunction() {
		return mfunction;
	}

	public void setMfunction(ModuleFunction mfunction) {
		this.mfunction = mfunction;
	}

}
