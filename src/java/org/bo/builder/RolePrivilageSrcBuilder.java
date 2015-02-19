package org.bo.builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.RolePrivilage;
import org.bo.util.PropertyLooker;

public class RolePrivilageSrcBuilder extends DefaultAction {
	StringBuilder sbxml = new StringBuilder();
	StringBuilder sbvm = new StringBuilder();
	File filevm = null;
	private String id,directory,rolename;
	

	public String execute() {
		SrcBuilderLeaf rpxml;
		List<RolePrivilage> roleprivilages = new ArrayList<RolePrivilage>();
		roleprivilages = persistence.getList("FROM " + RolePrivilage.class.getName()
				+ " rp WHERE rp.role.id='"+getId()+"'");
		rolename = roleprivilages.get(0).getRole().getName().toLowerCase().replaceAll("\\s", "");
		sbxml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n\n<!DOCTYPE struts PUBLIC\n")
		.append("\t\"-//Apache Software Foundation//DTD Struts Configuration 2.0//EN\"\n")
		.append("\t\"http://struts.apache.org/dtds/struts-2.0.dtd\">\n\n<struts>\n");
		
		sbvm.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n")
		.append("<title>Title</title><link type=\"text/css\" rel=\"stylesheet\" href=\"../../style.css\">\n</head>\n<body>\n<form method=\"post\" action='#'>\n")
		.append("\t<table bgcolor=\"#98COF4\" border=\"0\" cellpadding=\"5\" cellspacing=\"1\" width=\"98%\">\n")
		.append("\t\t<tr bgcolor=\"#d0dcff\"><td><strong>Form Title</strong></td></tr>\n\t\t<tr bgcolor=\"white\">\n\t\t\t<td>")
		.append("\t\t\t\tInsert Your Code Here .... !!\n\t\t\t</td>\n\t\t</tr>\n")
		.append("\t\t<tr bgcolor=\"#e4e4e4\">\n\t\t\t<td><input type=\"submit\"/></td>\n\t\t</tr>\n\t</table>\n</body>\n</form>\n</html>");

		for (RolePrivilage rpl : roleprivilages) {
			rpxml = new SrcBuilderLeaf(rpl.getModuleFunction().getId(), 0, persistence );
			sbxml.append(rpxml.createXmlCode(rolename, sbvm, filevm, directory));
		}

		sbxml.append("</struts>");
		(new File(getDirectory()+"/src/java")).mkdirs();
		File filexml = new File(getDirectory()+"/src/java/struts-"+rolename+".xml");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filexml));
			writer.write(sbxml.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getDefaultDirectory(){
		return PropertyLooker.get("aplication.workspace.default");
	}
	
	
}
