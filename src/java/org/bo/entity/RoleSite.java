package org.bo.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bo.DefaultPersistence;
import org.bo.entity.RoleSite;


@Entity()
@Table(name="role_site")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RoleSite extends DefaultPersistence{
	
	private Role role;
	private Site site;
	
	/**
	 * 
	 * @hibernate.many-to-one column="role_id"
	 */
	@ManyToOne
	@JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 * @hibernate.many-to-one column="site_id"
	 */
	@ManyToOne
	@JoinColumn(name="rsite_id")
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
}
