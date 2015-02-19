package org.bo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.bo.DefaultPersistence;


@Entity()
@Table(name="workflow_role")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Role extends DefaultPersistence {
	private String name;
	private String description;
	private List<RolePrivilage> rolePrivilage = new ArrayList<RolePrivilage>();
	
	/**
	 * @return Returns the description.
	 * @hibernate.property length="125"
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
	 * @return Returns the name.
	 * @hibernate.property length="50"
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
	
	
	@OneToMany(mappedBy="role", cascade={CascadeType.ALL})
	public List<RolePrivilage> getRolePrivilage() {
		return rolePrivilage;
	}
	/**
	 * @param rolePrivilage The rolePrivilage to set.
	 */
	public void setRolePrivilage(List<RolePrivilage> rolePrivilage) {
		this.rolePrivilage = rolePrivilage;
	}
	
	
	
}