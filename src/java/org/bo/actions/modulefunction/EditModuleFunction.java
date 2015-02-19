package org.bo.actions.modulefunction;
import org.bo.entity.Descriptor;

public class EditModuleFunction extends ViewModuleFunction {
	protected Descriptor moduleDescriptor;
	private String moduleDescriptorId="";
	
	public String execute(){

		String result = super.execute();

		return SUCCESS;
	}
	
	
	
	/**
	 * @return Returns the moduleDescriptorId.
	 */
	public String getModuleDescriptorId() {
		return moduleDescriptorId;
	}
	/**
	 * @param moduleDescriptorId The moduleDescriptorId to set.
	 */
	public void setModuleDescriptorId(String moduleDescriptorId) {
		this.moduleDescriptorId = moduleDescriptorId;
	}
	
	/**
	 * @return Returns the moduleDescriptor.
	 */
	public Descriptor getModuleDescriptor() {
		return moduleDescriptor;
	}
	/**
	 * @param moduleDescriptor The moduleDescriptor to set.
	 */
	public void setModuleDescriptor(Descriptor moduleDescriptor) {
		this.moduleDescriptor = moduleDescriptor;
	}


	
}
