package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the txout_approx database table.
 * 
 */
@Entity
@Table(name="txout_approx")
@NamedQuery(name="TxoutApprox.findAll", query="SELECT t FROM TxoutApprox t")
public class TxoutApprox implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tx_id")
	private BigDecimal txId;

	@Column(name="txout_approx_value")
	private BigDecimal txoutApproxValue;

	@Column(name="txout_id")
	private BigDecimal txoutId;

	public TxoutApprox() {
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public void setTxId(BigDecimal txId) {
		this.txId = txId;
	}

	public BigDecimal getTxoutApproxValue() {
		return this.txoutApproxValue;
	}

	public void setTxoutApproxValue(BigDecimal txoutApproxValue) {
		this.txoutApproxValue = txoutApproxValue;
	}

	public BigDecimal getTxoutId() {
		return this.txoutId;
	}

	public void setTxoutId(BigDecimal txoutId) {
		this.txoutId = txoutId;
	}

}