package org.bo.actions.role;


import org.bo.DefaultAction;
import org.bo.entity.Role;
import org.bo.entity.User;
import org.bo.util.PropertyLooker;

public class RoleForm extends DefaultAction {
	protected Role role = new Role();
	protected User user = new User();
	private String id;
	private String name="";
	private String description="";
	public String execute(){
		System.out.println(getCurrentUser().getId());
		user = (User) persistence.getById(User.class, getCurrentUser().getId());
		return SUCCESS;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	

	public String getDefaultDirectory(){
		return PropertyLooker.get("aplication.workspace.default");
	}
	
}
