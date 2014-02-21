package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedQuery(name="Txout.findAll", query="SELECT t FROM Txout t")
public class Txout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txout_id")
	private BigDecimal txoutId;

	@Column(name="tx_id")
	private BigDecimal txId;

	@Column(name="txout_pos")
	private BigDecimal txoutPos;

	@Column(name="txout_scriptpubkey")
	private String txoutScriptpubkey;

	@Column(name="txout_value")
	private BigDecimal txoutValue;

	@ManyToOne
	@JoinColumn(name="pubkey_id")
	private Pubkey pubkey;

	public Txout() {
	}

	public BigDecimal getTxoutId() {
		return this.txoutId;
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public BigDecimal getTxoutPos() {
		return this.txoutPos;
	}

	public String getTxoutScriptpubkey() {
		return this.txoutScriptpubkey;
	}

	public BigDecimal getTxoutValue() {
		return this.txoutValue;
	}

	public Pubkey getPubkey() {
		return this.pubkey;
	}
}