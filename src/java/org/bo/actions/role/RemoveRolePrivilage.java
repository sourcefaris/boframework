package org.bo.actions.role;

import org.bo.DefaultAction;
import org.bo.entity.Role;
import org.bo.entity.RolePrivilage;

public class RemoveRolePrivilage extends DefaultAction{
	private RolePrivilage rf;
	private Role role;
	private String rolePrivilageId = "";
	private String id = "";
	
	public String execute() {
		if(!getRolePrivilageId().equalsIgnoreCase("") && !getId().equalsIgnoreCase("")){
			rf = (RolePrivilage) persistence.getById(RolePrivilage.class, getRolePrivilageId());
			role = (Role) persistence.getById(Role.class, getId());
			persistence.remove(rf);
			return SUCCESS;
		}
		
		return ERROR;
	}
	/**
	 * @return Returns the rf.
	 */
	public RolePrivilage getRf() {
		return rf;
	}
	/**
	 * @param rf The rf to set.
	 */
	public void setRf(RolePrivilage rf) {
		this.rf = rf;
	}
	/**
	 * @return Returns the role.
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role The role to set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * @return Returns the rolePrivilageId.
	 */
	public String getRolePrivilageId() {
		return rolePrivilageId;
	}
	/**
	 * @param rolePrivilageId The rolePrivilageId to set.
	 */
	public void setRolePrivilageId(String rolePrivilageId) {
		this.rolePrivilageId = rolePrivilageId;
	}
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}
}
