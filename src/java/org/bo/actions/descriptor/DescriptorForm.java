package org.bo.actions.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.Descriptor;

public class DescriptorForm extends DefaultAction {
	private String id;
	private String name = "";
	private String description = "";
	private String actionName = "";
	protected Descriptor descr = new Descriptor();
	protected List<Descriptor> descrs = new ArrayList<Descriptor>();

	public String execute() {
		return SUCCESS;
	}

	public List<Descriptor> getDescrs() {
		return descrs;
	}

	public void setDescrs(List<Descriptor> descrs) {
		this.descrs = descrs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Descriptor getDescr() {
		return descr;
	}

	public void setDescr(Descriptor descr) {
		this.descr = descr;
	}

}