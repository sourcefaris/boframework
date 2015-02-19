package org.bo.actions.role;

import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.Role;

public class ListRole extends DefaultAction 
{
	private List<Role> roles;
	private String orderBy="name";
	private String direction="asc";
	
	public String execute() throws Exception {
		
		roles = persistence.findAllSortedDirected(Role.class, getOrderBy(), getDirection());
		
		return SUCCESS;
	}
	
	

	/**
	 * @return Returns the direction.
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction The direction to set.
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return Returns the orderBy.
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy The orderBy to set.
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return Returns the roles.
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles The roles to set.
	 */
	public void setRoles(List<Role> workflows) {
		this.roles = workflows;
	}
}
