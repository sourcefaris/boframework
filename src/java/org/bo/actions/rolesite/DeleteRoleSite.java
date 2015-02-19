package org.bo.actions.rolesite;

import org.bo.entity.Role;
import org.bo.entity.RoleSite;

public class DeleteRoleSite extends RoleSiteForm {
	public String execute(){
		if(getRole().getId() != null && !"".equalsIgnoreCase(getRole().getId())){
			setRole((Role) persistence.getById(Role.class, getRole().getId()));
			setRolesites(persistence.getList("FROM " + RoleSite.class.getName() + " rs " +
					"WHERE rs.role.id='" + getRole().getId() + "'"));
		}
		if(getRolesite().getId() != null && !"".equalsIgnoreCase(getRolesite().getId())){
			setRolesite((RoleSite) persistence.getById(RoleSite.class, getRolesite().getId()));
			persistence.remove(getRolesite());
		}
		return SUCCESS;
	}
}
