package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;

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

	public String getConfigvarValue() {
		return this.configvarValue;
	}
}