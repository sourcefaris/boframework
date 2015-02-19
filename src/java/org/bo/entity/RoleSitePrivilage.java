package org.bo.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

/**
 * 
 * @hibernate.class table="role_site_privilage"
 *
 */
@Entity()
@Table(name="role_site_privilage")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RoleSitePrivilage extends DefaultPersistence{
	
	private RoleSite roleSite;
	private Site site;
	private ModuleFunction moduleFunction;
	
	/**
	 * @return Returns the roleSite.
	 * @hibernate.many-to-one column="role_site_id"
	 */
	@ManyToOne
	@JoinColumn(name="role_site_id")
	public RoleSite getRoleSite() {
		return roleSite;
	}
	/**
	 * @param roleSite The roleSite to set.
	 */
	public void setRoleSite(RoleSite roleSite) {
		this.roleSite = roleSite;
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
	
	/**
	 * 
	 * @hibernate.many-to-one column="site_id"
	 */
	@ManyToOne
	@JoinColumn(name="rs_site_id")
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
//	/**
//	 * @return Returns the rs_site_id.
//	 * @hibernate.property
//	 */
//	public String getRs_site_id() {
//		return rs_site_id;
//	}
//	public void setRs_site_id(String rs_site_id) {
//		this.rs_site_id = rs_site_id;
//	}
	
	
}
