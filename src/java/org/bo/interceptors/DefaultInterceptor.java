package org.bo.interceptors;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.bo.entity.Descriptor;
import org.bo.entity.ModuleFunction;
import org.bo.entity.Role;
import org.bo.entity.RolePrivilage;
import org.bo.entity.RoleSitePrivilage;
import org.bo.entity.User;
import org.bo.persistence.PersistenceAware;
import org.bo.persistence.PersistenceManager;
import org.bo.security.LoginFilter;
import org.bo.security.SessionCredentials;
import org.bo.security.SessionCredentialsAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DefaultInterceptor implements Interceptor, PersistenceAware,
		SessionCredentialsAware {
	private PersistenceManager manager;
	private SessionCredentials sessCredentials;
	private String siteId;
	private Role currentRole;
	private User currentUser;
	private Descriptor descriptorCalled;

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if (sessCredentials.getCurrentUser() != null) {
			// init currentSite
			siteId = (String) ServletActionContext.getRequest().getSession()
					.getAttribute(LoginFilter.LOGIN_GS_SITE);
			// init currentUser
			currentUser = sessCredentials.getCurrentUser();
			currentRole = currentUser.getRole();

			// init descriptorCalled
			String namespace = actionInvocation.getProxy().getNamespace();
			String descriptorCandidate[] = namespace.split("/");
			if ("module".equalsIgnoreCase(descriptorCandidate[1])) {
				String descriptorName = descriptorCandidate[2];
				descriptorCalled = (Descriptor) manager.getByUniqueField(
						Descriptor.class, descriptorName, "name");
				if (descriptorCalled != null) {
					if (!isAuthorized(actionInvocation)) {
						return "notallowed";
					}
				} else {
					return "notallowed";
				}
			}
		}
		return actionInvocation.invoke();
	}

	private boolean isAuthorized(ActionInvocation actionInvocation) {
		List<ModuleFunction> modules = new ArrayList<ModuleFunction>();

		String mySQL;
		if (siteId != null && !"".equalsIgnoreCase(siteId)) {
			// read all module function from role_site_privilage.
			mySQL = "SELECT rsp FROM " + RoleSitePrivilage.class.getName()
					+ " rsp WHERE rsp.roleSite.site.id = '" + siteId
					+ "' AND rsp.roleSite.role.id = '" + currentRole.getId()+"'";
			List<RoleSitePrivilage> rsp = new ArrayList<RoleSitePrivilage>();
			rsp = (List<RoleSitePrivilage>) manager.getList(mySQL);
			for (RoleSitePrivilage tmp : rsp) {
				if (checkLeafDescriptor(tmp.getModuleFunction())) {
					return true;
				}
			}
		} else {
			// read all module function from role_privilage
			mySQL = "SELECT rp FROM " + RolePrivilage.class.getName()
					+ " rp WHERE rp.role.id='" + currentRole.getId()+"'";
			List<RolePrivilage> rp = new ArrayList<RolePrivilage>();
			rp = (List<RolePrivilage>) manager.getList(mySQL);
			for (RolePrivilage tmp : rp) {
				if (checkLeafDescriptor(tmp.getModuleFunction())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkLeafDescriptor(ModuleFunction parent) {
		for (ModuleFunction mf : parent.getModuleFunctions()) {
			if(mf.getModuleFunctions().size()>0) {
				if (checkLeafDescriptor(mf)) {
					return true;
				}
			} else {
				if (descriptorCalled.equals(mf.getModuleDescriptor())) {
					return true;
				}
			} 
		}
		return false;
	}

	private List<ModuleFunction> getLeafPrivilage(ModuleFunction parent) {
		List<ModuleFunction> mfs = new ArrayList<ModuleFunction>();
		for (ModuleFunction mf : parent.getModuleFunctions()) {
			if (mf.getModuleFunctions().size() > 0) {
				mfs.addAll(getLeafPrivilage(mf));
			} else {
				mfs.add(mf);
			} 
		}
		return mfs;
	}

	public void setPersistenceManager(PersistenceManager arg0) {
		this.manager = arg0;
	}

	public void setSessionCredentials(SessionCredentials arg0) {
		this.sessCredentials = arg0;
	}

}
