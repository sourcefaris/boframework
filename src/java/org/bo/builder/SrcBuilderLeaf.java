package org.bo.builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.bo.entity.ModuleFunction;
import org.bo.persistence.PersistenceManager;

public class SrcBuilderLeaf {
	String sId;
	int node,i ;
	PersistenceManager pm;
	String mySQL;
	String XML_BUILDER_LEAF="";
	
	public SrcBuilderLeaf( String rootId , int node, PersistenceManager manager) {
		this.sId=rootId;
		this.node = node;
		this.pm = manager;
	}
	
	public String createXmlCode(String rolename, StringBuilder sbvm, File filevm, String directory){
		SrcBuilderLeaf rpb;

		String sParentId="";
		i=0;
		mySQL = "FROM mf in " + ModuleFunction.class + " WHERE mf.moduleFunction.id = '" + this.sId + "' ORDER BY(mf.description)";
		
		List<ModuleFunction> modules = new ArrayList<ModuleFunction>();
		modules = pm.getList(mySQL);
		
		for(ModuleFunction mf : modules){
			
			sParentId = mf.getId();
			
			ModuleFunction modf = (ModuleFunction) pm.getById(ModuleFunction.class, sParentId);
			int totalChild ;
			rpb = new SrcBuilderLeaf(modf.getId(), i, pm);
			
			totalChild = rpb.getChildCount();	
			
			if(totalChild>0){
				XML_BUILDER_LEAF = XML_BUILDER_LEAF+rpb.createXmlCode(rolename, sbvm, filevm, directory);
			} else {
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t<!-- "+mf.getModuleDescriptor().getDescription()+" -->\n";
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t<package name=\""+mf.getModuleDescriptor().getName()+"\" extends=\"default\" namespace=\"/module/"+mf.getModuleDescriptor().getName()+"\">\n";
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t\t<action name=\""+mf.getModuleDescriptor().getActionName()+"\">\n";
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t\t\t<result name=\"success\" type=\"velocity\">\n";
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t\t\t\t/"+rolename+"/"+mf.getModuleDescriptor().getName()+"/index.vm\n";
				XML_BUILDER_LEAF=XML_BUILDER_LEAF+"\t\t\t</result>\n\t\t</action>\n\t</package>\n\n";
				
				boolean identification = (new File(directory+"/src/template/"+rolename+"/"+mf.getModuleDescriptor().getName())).mkdirs();
				filevm = new File(directory+"/src/template/"+rolename+"/"+mf.getModuleDescriptor().getName()+"/index.vm");
				if(!filevm.exists()){
					try {
						BufferedWriter writ = new BufferedWriter(new FileWriter(filevm));
						writ.write(sbvm.toString());
						writ.close();
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			i++;
		}
		return XML_BUILDER_LEAF;
	}
	
	public int getChildCount(){
		String mySQL = "FROM "+ModuleFunction.class.getName()+" mf WHERE mf.logInformation.activeFlag='1' AND mf.moduleFunction.id='"+this.sId+"'";
		List temp = new ArrayList();
		temp = pm.getList(mySQL);
		
		return temp.size();
	}
}