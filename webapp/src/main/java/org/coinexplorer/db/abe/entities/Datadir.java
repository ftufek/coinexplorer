package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the datadir database table.
 * 
 */
@Entity
@NamedQuery(name="Datadir.findAll", query="SELECT d FROM Datadir d")
public class Datadir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="datadir_id")
	private long datadirId;

	@Column(name="blkfile_number")
	private BigDecimal blkfileNumber;

	@Column(name="blkfile_offset")
	private BigDecimal blkfileOffset;

	@Column(name="chain_id")
	private BigDecimal chainId;

	private String dirname;

	public Datadir() {
	}

	public long getDatadirId() {
		return this.datadirId;
	}

	public void setDatadirId(long datadirId) {
		this.datadirId = datadirId;
	}

	public BigDecimal getBlkfileNumber() {
		return this.blkfileNumber;
	}

	public void setBlkfileNumber(BigDecimal blkfileNumber) {
		this.blkfileNumber = blkfileNumber;
	}

	public BigDecimal getBlkfileOffset() {
		return this.blkfileOffset;
	}

	public void setBlkfileOffset(BigDecimal blkfileOffset) {
		this.blkfileOffset = blkfileOffset;
	}

	public BigDecimal getChainId() {
		return this.chainId;
	}

	public void setChainId(BigDecimal chainId) {
		this.chainId = chainId;
	}

	public String getDirname() {
		return this.dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

}