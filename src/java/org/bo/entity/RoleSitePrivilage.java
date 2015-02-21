package org.bo.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

@Entity()
@Table(name = "role_site_privilage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RoleSitePrivilage extends DefaultPersistence {

	private RoleSite roleSite;
	private Site site;
	private ModuleFunction moduleFunction;

	@ManyToOne
	@JoinColumn(name = "role_site_id")
	public RoleSite getRoleSite() {
		return roleSite;
	}

	public void setRoleSite(RoleSite roleSite) {
		this.roleSite = roleSite;
	}

	@ManyToOne
	@JoinColumn(name = "module_function_id")
	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}

	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}

	@ManyToOne
	@JoinColumn(name = "rs_site_id")
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
