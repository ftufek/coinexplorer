package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tx database table.
 * 
 */
@Entity
@NamedQuery(name="Tx.findAll", query="SELECT t FROM Tx t")
public class Tx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tx_id")
	private long txId;

	@Column(name="tx_hash")
	private String txHash;

	@Column(name="tx_locktime")
	private BigDecimal txLocktime;

	@Column(name="tx_size")
	private BigDecimal txSize;

	@Column(name="tx_version")
	private BigDecimal txVersion;

	//bi-directional many-to-one association to BlockTx
	@OneToMany(mappedBy="tx")
	private List<BlockTx> blockTxs;

	//bi-directional many-to-one association to Txin
	@OneToMany(mappedBy="tx")
	private List<Txin> txins;

	public Tx() {
	}

	public long getTxId() {
		return this.txId;
	}

	public void setTxId(long txId) {
		this.txId = txId;
	}

	public String getTxHash() {
		return this.txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public BigDecimal getTxLocktime() {
		return this.txLocktime;
	}

	public void setTxLocktime(BigDecimal txLocktime) {
		this.txLocktime = txLocktime;
	}

	public BigDecimal getTxSize() {
		return this.txSize;
	}

	public void setTxSize(BigDecimal txSize) {
		this.txSize = txSize;
	}

	public BigDecimal getTxVersion() {
		return this.txVersion;
	}

	public void setTxVersion(BigDecimal txVersion) {
		this.txVersion = txVersion;
	}

	public List<BlockTx> getBlockTxs() {
		return this.blockTxs;
	}

	public void setBlockTxs(List<BlockTx> blockTxs) {
		this.blockTxs = blockTxs;
	}

	public List<Txin> getTxins() {
		return this.txins;
	}

	public void setTxins(List<Txin> txins) {
		this.txins = txins;
	}

	public Txin addTxin(Txin txin) {
		getTxins().add(txin);
		txin.setTx(this);

		return txin;
	}

	public Txin removeTxin(Txin txin) {
		getTxins().remove(txin);
		txin.setTx(null);

		return txin;
	}

}