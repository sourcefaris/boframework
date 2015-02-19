package org.bo.actions.role;

import org.bo.entity.Role;

public class ViewRole extends RoleForm {
	private Role role = new Role();
	private String id;
	public String execute() {
		role = (Role) persistence.getById(Role.class, getId());

		if (role == null) {
			addActionError("Such role couldn't be found");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role=role;
	}
}