package org.bo.security.actions.rsp;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.ModuleFunction;
import org.bo.entity.RolePrivilage;
import org.bo.entity.RoleSite;
import org.bo.entity.RoleSitePrivilage;

public class ViewMod extends DefaultAction{
	private List<ModuleFunction> mfunctions = new ArrayList<ModuleFunction>();
	private RoleSite roleSite = new RoleSite();
	
	public String execute(){
		List<RoleSitePrivilage> rsps = new ArrayList<RoleSitePrivilage>();
		List<RolePrivilage> rps = new ArrayList<RolePrivilage>();
		if(getRoleSite().getId() != null && !"".equalsIgnoreCase(getRoleSite().getId())){
			setRoleSite((RoleSite) persistence.getById(RoleSite.class, getRoleSite().getId()));

			rps = persistence.getList("FROM " + RolePrivilage.class.getName() + " rp " +
					"WHERE rp.role.id='" + getRoleSite().getRole().getId() + "' " +
					"AND rp.logInformation.activeFlag=1");
			for(RolePrivilage rp : rps){
				mfunctions.add(rp.getModuleFunction());
			}
			
			rsps = persistence.getList("FROM " + RoleSitePrivilage.class.getName() + " rsp " +
					"WHERE rsp.roleSite.id='" + getRoleSite().getId() + "' " +
					"AND rsp.logInformation.activeFlag=1");
			for(RoleSitePrivilage rsp : rsps){
				mfunctions.remove(rsp.getModuleFunction());
			}
			
		}
		return SUCCESS;
	}

	public List<ModuleFunction> getMfunctions() {
		return mfunctions;
	}

	public void setMfunctions(List<ModuleFunction> mfunctions) {
		this.mfunctions = mfunctions;
	}

	public RoleSite getRoleSite() {
		return roleSite;
	}

	public void setRoleSite(RoleSite roleSite) {
		this.roleSite = roleSite;
	}
	
}
	
	
	