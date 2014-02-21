package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the configvar database table.
 * 
 */
@Entity
@NamedQuery(name="Configvar.findAll", query="SELECT c FROM Configvar c")
public class Configvar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="configvar_name")
	private String configvarName;

	@Column(name="configvar_value")
	private String configvarValue;

	public Configvar() {
	}

	public String getConfigvarName() {
		return this.configvarName;
	}

	public void setConfigvarName(String configvarName) {
		this.configvarName = configvarName;
	}

	public String getConfigvarValue() {
		return this.configvarValue;
	}

	public void setConfigvarValue(String configvarValue) {
		this.configvarValue = configvarValue;
	}

}