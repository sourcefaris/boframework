package org.bo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.bo.DefaultPersistence;


@Entity()
@Table(name="descriptor")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Descriptor extends DefaultPersistence {
	private String name;
	private String description;
	private String action = "";

	/**
	 * @return Returns the name.
	 * @hibernate.property
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the description.
	 * @hibernate.property
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the action.
	 * @hibernate.property column="action"
	 */
	@Column(name="action")
	public String getActionName() {
		return action;
	}
	/**
	 * @param action The action to set.
	 */
	public void setActionName(String action) {
		this.action = action;
	}

	
}
