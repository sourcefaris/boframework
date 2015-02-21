package org.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

@Entity()
@Table(name = "descriptor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Descriptor extends DefaultPersistence {
	private String name;
	private String description;
	private String action = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "action")
	public String getActionName() {
		return action;
	}

	public void setActionName(String action) {
		this.action = action;
	}

}
