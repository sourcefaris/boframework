package org.bo.security.actions.rsp;

import org.bo.entity.RoleSitePrivilage;

public class Delete extends Master {

	public String execute() {
		if(getRsp().getId() != null && !"".equalsIgnoreCase(getRsp().getId())){
			setRsp((RoleSitePrivilage) persistence.getById(RoleSitePrivilage.class, getRsp().getId()));
			setRoleSite(getRsp().getRoleSite());
			persistence.remove(getRsp());
		}
		return SUCCESS;
	}
}