package org.bo.actions.rolesite;

import java.sql.Timestamp;

import org.bo.LogInformation;
import org.bo.entity.Role;
import org.bo.entity.RoleSite;
import org.bo.entity.Site;

public class SaveRoleSite extends RoleSiteForm {
	public String execute(){
		if(getRole().getId() != null && !"".equalsIgnoreCase(getRole().getId())){
			setRole((Role) persistence.getById(Role.class, getRole().getId()));
		} else {
			addActionError("Select role first");
			return "select_role";
		}
		if(getSite().getId() != null && !"".equalsIgnoreCase(getSite().getId())){
			setSite((Site) persistence.getById(Site.class, getSite().getId()));
		} else {
			addActionError("Select Site");
			return INPUT;
		}
		LogInformation log = new LogInformation();
		log.setActiveFlag(LogInformation.ACTIVE);
		log.setCreateBy(getCurrentUser().getId());
		log.setCreateDate(new Timestamp(System.currentTimeMillis()));
		log.setLastUpdateBy(getCurrentUser().getId());
		log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		getRolesite().setRole(getRole());
		getRolesite().setSite(getSite());
		getRolesite().setLogInformation(log);
		persistence.save(getRolesite());
		return SUCCESS;
	}

}
