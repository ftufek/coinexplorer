package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="unlinked_txin")
@NamedQuery(name="UnlinkedTxin.findAll", query="SELECT u FROM UnlinkedTxin u")
public class UnlinkedTxin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txin_id")
	private BigDecimal txinId;

	@Column(name="txout_pos")
	private BigDecimal txoutPos;

	@Column(name="txout_tx_hash", columnDefinition="bpchar(64)")
	private String txoutTxHash;

	@OneToOne
	@JoinColumn(name="txin_id")
	private Txin txin;

	public UnlinkedTxin() {
	}

	public BigDecimal getTxinId() {
		return this.txinId;
	}

	public BigDecimal getTxoutPos() {
		return this.txoutPos;
	}

	public String getTxoutTxHash() {
		return this.txoutTxHash;
	}

	public Txin getTxin() {
		return this.txin;
	}
}