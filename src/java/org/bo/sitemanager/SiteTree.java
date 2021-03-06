package org.bo.sitemanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.bo.DefaultAction;
import org.bo.entity.RolePrivilage;
import org.bo.entity.User;
import org.bo.security.LoginFilter;

public class SiteTree extends DefaultAction {
	private String roleId = "";
	private String siteId = "";
	private String tree_script = "";

	public String execute() {

		String mySQL;
		String MTMJavaScript = "";
		int total_role_site = 0;
		String variableNode = "menu";

		SiteTreeLeaf dbTree;

		try {
			User us = getCurrentUser();
			this.roleId = us.getRole().getId();

			int iFirstNode = 0;
			
			// read all module function from role_privilage
			mySQL = "FROM tmp in " + RolePrivilage.class
					+ " WHERE tmp.role.id='" + this.roleId
					+ "' ORDER BY (tmp.moduleFunction.sorting)";
			List<RolePrivilage> rp = new ArrayList<RolePrivilage>();
			rp = (List<RolePrivilage>) persistence.getList(mySQL);
			for (RolePrivilage tmp : rp) {
				dbTree = new SiteTreeLeaf(
						tmp.getModuleFunction().getId(), variableNode,
						iFirstNode, persistence);

				MTMJavaScript = MTMJavaScript + "<div class=\"pkg\"><h3>"
						+ tmp.getModuleFunction().getDescription()
						+ "</h3><div class=\"pkg-body\">";
				// check the child is > 0
				MTMJavaScript = MTMJavaScript + dbTree.getMTMJavaScript();
				MTMJavaScript = MTMJavaScript + "</div></div>";
			}
			tree_script = MTMJavaScript;
			return SUCCESS;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getTree_script() {
		return tree_script;
	}

	public void setTree_script(String tree_script) {
		this.tree_script = tree_script;
	}
}
