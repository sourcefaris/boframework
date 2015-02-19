package org.bo.actions.rolesite;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.Role;
import org.bo.entity.RoleSite;
import org.bo.entity.Site;

public class RoleSiteForm extends DefaultAction {
	private List<Role> roles = new ArrayList<Role>();
	private List<RoleSite> rolesites = new ArrayList<RoleSite>();
	private RoleSite rolesite = new RoleSite();
	private Site site = new Site();
	private Role role = new Role();

	public String execute() {
		if (getRole().getId() != null
				&& !"".equalsIgnoreCase(getRole().getId())) {
			setRole((Role) persistence.getById(Role.class, getRole().getId()));
			setRolesites(persistence.getList("FROM " + RoleSite.class.getName()
					+ " rs " + "WHERE rs.role.id='" + getRole().getId()
					+ "' AND rs.logInformation.activeFlag='"
					+ LogInformation.ACTIVE + "'"));
		}
		if (getRolesite().getId() != null
				&& !"".equalsIgnoreCase(getRolesite().getId())) {
			setRolesite((RoleSite) persistence.getById(RoleSite.class,
					getRolesite().getId()));
		}
		setRoles(persistence.getList("FROM " + Role.class.getName()
				+ " tmp " + "WHERE tmp.logInformation.activeFlag='"
				+ LogInformation.ACTIVE + "'"));
		return SUCCESS;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<RoleSite> getRolesites() {
		return rolesites;
	}

	public void setRolesites(List<RoleSite> rolesites) {
		this.rolesites = rolesites;
	}

	public RoleSite getRolesite() {
		return rolesite;
	}

	public void setRolesite(RoleSite rolesite) {
		this.rolesite = rolesite;
	}

}
