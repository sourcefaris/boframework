package org.bo.actions.descriptor;

import java.util.List;

import org.bo.DefaultAction;
import org.bo.LogInformation;
import org.bo.entity.Descriptor;

public class ListDescriptor extends DefaultAction {

	private List<Descriptor> descriptors;

	public String execute() {
		descriptors = persistence.getList("FROM " + Descriptor.class.getName()
				+ " tmp WHERE tmp.logInformation.activeFlag='"
				+ LogInformation.ACTIVE + "'");
		return SUCCESS;

	}

	public List<Descriptor> getDescriptors() {
		return descriptors;
	}
}
