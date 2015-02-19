package org.bo.actions.company;

import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.Descriptor;

public class ListCompany extends DefaultAction {

	private List descriptors;
	
	public String execute() {
		descriptors = persistence.findAllSorted(Descriptor.class, "name");
		return SUCCESS;
	
	}

	public List getDescriptors() {
		return descriptors;
	}
}
