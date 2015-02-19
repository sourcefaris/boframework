package org.bo.actions.descriptor;

import org.bo.entity.Descriptor;

public class ViewDescriptor extends DescriptorForm{
	protected Descriptor descriptor;
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Descriptor getDescriptor() {
		return descriptor;
	}
	public String execute() {

		descriptor = (Descriptor) persistence.getById(Descriptor.class, getId());
		if (descriptor == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}