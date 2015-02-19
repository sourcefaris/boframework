package org.bo.sitemanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bo.entity.ModuleFunction;
import org.bo.persistence.PersistenceManager;

public class SiteTreeLeaf {

	private ModuleFunction moduleFunction=null;
	private String sId="";
	private String MTMJavaScript="",variableNode="";
	private int i, Node;
	private PersistenceManager pm;
	// default variable
	String mySQL;       

	/**
	 * Constructor:
	 * rootId = Root Id of the tree
	 * level = level of the tree, this will be use recursively, so the level must 0.
	 * recursiveList = your current LinkedList.
	 */

	/**
	 * Constructor for recursive only
	 */
	public SiteTreeLeaf ( String rootId , String variableNode, int Node,PersistenceManager manager) throws ClassNotFoundException, Exception  {
		this.sId = rootId;
		this.moduleFunction = (ModuleFunction) manager.getById(ModuleFunction.class, rootId);	
		this.Node=Node;
		this.variableNode=variableNode;
		this.pm = manager;
	}

	/**
	 * return moduleFunction
	 */
	public ModuleFunction getRoot() {
		return 	this.moduleFunction;
	}

	/**
	 * return int that contains count all downline
	 */	
	public int getChildCount()throws ClassNotFoundException, SQLException, Exception {
		/**
		 * modified in 24 july'06 using hibernate
		 */
		mySQL = "FROM "+ModuleFunction.class.getName()+" mf WHERE mf.logInformation.activeFlag='1' AND mf.moduleFunction.id='"+this.sId+"'";
		List temp = new ArrayList();
		temp = pm.getList(mySQL);
		return temp.size();
	}

	public String getMTMJavaScript()throws ClassNotFoundException, SQLException, Exception {
		SiteTreeLeaf dbTreeWalkerChild;

		String sParentId="";
		i=0;
		mySQL = "FROM mf in " + ModuleFunction.class + " WHERE mf.moduleFunction.id = '" + this.sId + "' ORDER BY(mf.description)";
		List<ModuleFunction> modules = new ArrayList<ModuleFunction>();
		modules = (List<ModuleFunction>)pm.getList(mySQL);
		for(ModuleFunction mf : modules) { 

			sParentId = mf.getId();

			// add to List
			ModuleFunction mFunction = (ModuleFunction) pm.getById(ModuleFunction.class, sParentId);

			int totalChild ;
			dbTreeWalkerChild = new SiteTreeLeaf(mFunction.getId(), variableNode+"_"+Node, i, pm);

			totalChild = dbTreeWalkerChild.getChildCount();	

			// check the child after this object. if > 0 mean generate leaf descriptor
			if (totalChild>0) {
				MTMJavaScript = MTMJavaScript + "<div class=\"pkg\"><h3>"+mf.getDescription()+"</h3><div class=\"pkg-body\">"; //dbTreeChild.getDescription();
				MTMJavaScript = MTMJavaScript + dbTreeWalkerChild.getMTMJavaScript();
				MTMJavaScript = MTMJavaScript + "</div></div>";
			} else {
				String sUrlAction="";
				sUrlAction = "../module/"+mf.getModuleDescriptor().getName()+"/"+mf.getModuleDescriptor().getActionName();
				MTMJavaScript = MTMJavaScript + "<div class=\"pkg-body\">";
				
				MTMJavaScript = MTMJavaScript + "<a href=\""+sUrlAction+".action\">"+mf.getDescription()+"</a>";
				MTMJavaScript = MTMJavaScript + "</div>";
			}
			i++;
		}
		return MTMJavaScript;
	}
}