package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NamedQuery(name="Tx.findAll", query="SELECT t FROM Tx t")
public class Tx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tx_id")
	private BigDecimal txId;

	@Column(name="tx_hash", columnDefinition="bpchar(64)")
	private String txHash;

	@Column(name="tx_locktime")
	private BigDecimal txLocktime;

	@Column(name="tx_size")
	private BigDecimal txSize;

	@Column(name="tx_version")
	private BigDecimal txVersion;

	@OneToMany(mappedBy="tx")
	private List<BlockTx> blockTxs;

	@OneToMany(mappedBy="tx")
	private List<Txin> txins;

	public Tx() {
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public String getTxHash() {
		return this.txHash;
	}

	public BigDecimal getTxLocktime() {
		return this.txLocktime;
	}

	public BigDecimal getTxSize() {
		return this.txSize;
	}

	public BigDecimal getTxVersion() {
		return this.txVersion;
	}
	
	public List<BlockTx> getBlockTxs() {
		return this.blockTxs;
	}

	public List<Txin> getTxins() {
		return this.txins;
	}
}