package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the txout database table.
 * 
 */
@Entity
@NamedQuery(name="Txout.findAll", query="SELECT t FROM Txout t")
public class Txout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txout_id")
	private long txoutId;

	@Column(name="tx_id")
	private BigDecimal txId;

	@Column(name="txout_pos")
	private BigDecimal txoutPos;

	@Column(name="txout_scriptpubkey")
	private String txoutScriptpubkey;

	@Column(name="txout_value")
	private BigDecimal txoutValue;

	//bi-directional many-to-one association to Pubkey
	@ManyToOne
	@JoinColumn(name="pubkey_id")
	private Pubkey pubkey;

	public Txout() {
	}

	public long getTxoutId() {
		return this.txoutId;
	}

	public void setTxoutId(long txoutId) {
		this.txoutId = txoutId;
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public void setTxId(BigDecimal txId) {
		this.txId = txId;
	}

	public BigDecimal getTxoutPos() {
		return this.txoutPos;
	}

	public void setTxoutPos(BigDecimal txoutPos) {
		this.txoutPos = txoutPos;
	}

	public String getTxoutScriptpubkey() {
		return this.txoutScriptpubkey;
	}

	public void setTxoutScriptpubkey(String txoutScriptpubkey) {
		this.txoutScriptpubkey = txoutScriptpubkey;
	}

	public BigDecimal getTxoutValue() {
		return this.txoutValue;
	}

	public void setTxoutValue(BigDecimal txoutValue) {
		this.txoutValue = txoutValue;
	}

	public Pubkey getPubkey() {
		return this.pubkey;
	}

	public void setPubkey(Pubkey pubkey) {
		this.pubkey = pubkey;
	}

}