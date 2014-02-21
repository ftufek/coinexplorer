package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the unlinked_txin database table.
 * 
 */
@Entity
@Table(name="unlinked_txin")
@NamedQuery(name="UnlinkedTxin.findAll", query="SELECT u FROM UnlinkedTxin u")
public class UnlinkedTxin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txin_id")
	private long txinId;

	@Column(name="txout_pos")
	private BigDecimal txoutPos;

	@Column(name="txout_tx_hash")
	private String txoutTxHash;

	//bi-directional one-to-one association to Txin
	@OneToOne
	@JoinColumn(name="txin_id")
	private Txin txin;

	public UnlinkedTxin() {
	}

	public long getTxinId() {
		return this.txinId;
	}

	public void setTxinId(long txinId) {
		this.txinId = txinId;
	}

	public BigDecimal getTxoutPos() {
		return this.txoutPos;
	}

	public void setTxoutPos(BigDecimal txoutPos) {
		this.txoutPos = txoutPos;
	}

	public String getTxoutTxHash() {
		return this.txoutTxHash;
	}

	public void setTxoutTxHash(String txoutTxHash) {
		this.txoutTxHash = txoutTxHash;
	}

	public Txin getTxin() {
		return this.txin;
	}

	public void setTxin(Txin txin) {
		this.txin = txin;
	}

}