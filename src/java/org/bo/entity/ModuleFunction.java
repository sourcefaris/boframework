package org.bo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.bo.DefaultPersistence;

@Entity()
@Table(name = "module")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ModuleFunction extends DefaultPersistence {

	private String name;
	private String description;
	private List<ModuleFunction> moduleFunctions;
	private ModuleFunction moduleFunction;
	private Descriptor moduleDescriptor;
	private int sorting;

	@ManyToOne
	@JoinColumn(name = "descriptor_id")
	public Descriptor getModuleDescriptor() {
		return moduleDescriptor;
	}

	public void setModuleDescriptor(Descriptor moduleDescriptor) {
		this.moduleDescriptor = moduleDescriptor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "iparent", nullable = true, updatable = true, insertable = true)
	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}

	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}
	
	public int getSorting() {
		return sorting;
	}
	
	public void setSorting(int sorting) {
		this.sorting = sorting;
	}

	@OneToMany(mappedBy = "moduleFunction", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public List<ModuleFunction> getModuleFunctions() {
		return moduleFunctions;
	}

	public void setModuleFunctions(List<ModuleFunction> moduleFunctions) {
		this.moduleFunctions = moduleFunctions;
	}

}
