package org.bo.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

@Entity()
@Table(name="role_privilage")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RolePrivilage extends DefaultPersistence{
	
	private Role role;
	private ModuleFunction moduleFunction;
	
	/**
	 * @return Returns the role.
	 * @hibernate.many-to-one column="role_id"
	 */
	@ManyToOne
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
	 * @hibernate.many-to-one column="module_function_id"
	 * @return Returns the moduleFunction.
	 */
	@ManyToOne
	@JoinColumn(name="module_function_id")
	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}
	/**
	 * @param moduleFunction The moduleFunction to set.
	 */
	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}
}
