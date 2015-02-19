package org.bo.actions.descriptor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bo.LogInformation;
import org.bo.entity.Descriptor;

public class EditDescriptor extends DescriptorForm {
	protected List tmp = new ArrayList();

	public String execute() {
		System.out.println("UPDATE");
		Descriptor descr = (Descriptor) persistence.getById(Descriptor.class, getId());
		if (descr == null) {
			addActionError("Cannot find such descriptor");
			return ERROR;
		} else {
			if (getName().equalsIgnoreCase("")) {
				addActionError("Name can't be empty");
			}
			if (getDescription().equalsIgnoreCase("")) {
				addActionError("Description can't be empty");
			}
			
			descr.setName(getName());
			descr.setDescription(getDescription());
			descr.setActionName(getActionName());

			LogInformation log = descr.getLogInformation();
			/*
			 * fix this dude. this is not working well.
			*/
			
			if (getCurrentUser()!=null) {
			log.setLastUpdateBy(getCurrentUser().getId());
			log.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
			}

			descr.setLogInformation(log);

			if (hasErrors()) {
				return INPUT;
			} else {
				persistence.save(descr);
				return SUCCESS;
			}
		}
	}

}