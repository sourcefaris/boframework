package org.bo.actions.role;

import org.bo.DefaultAction;
import org.bo.entity.Role;
import org.bo.util.PropertyLooker;

public class RoleForm extends DefaultAction {
	protected Role role = new Role();
	private String id;
	private String name = "";
	private String description = "";

	public String execute() {
		return SUCCESS;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDefaultDirectory() {
		return PropertyLooker.get("application.workspace.default");
	}

}
