package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedQuery(name="Datadir.findAll", query="SELECT d FROM Datadir d")
public class Datadir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="datadir_id")
	private BigDecimal datadirId;

	@Column(name="blkfile_number")
	private BigDecimal blkfileNumber;

	@Column(name="blkfile_offset")
	private BigDecimal blkfileOffset;

	@Column(name="chain_id")
	private BigDecimal chainId;

	private String dirname;

	public Datadir() {
	}

	public BigDecimal getDatadirId() {
		return this.datadirId;
	}

	public BigDecimal getBlkfileNumber() {
		return this.blkfileNumber;
	}

	public BigDecimal getBlkfileOffset() {
		return this.blkfileOffset;
	}

	public BigDecimal getChainId() {
		return this.chainId;
	}

	public String getDirname() {
		return this.dirname;
	}
}