package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the txin database table.
 * 
 */
@Entity
@NamedQuery(name="Txin.findAll", query="SELECT t FROM Txin t")
public class Txin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txin_id")
	private long txinId;

	@Column(name="txin_pos")
	private BigDecimal txinPos;

	@Column(name="txin_scriptsig")
	private String txinScriptsig;

	@Column(name="txin_sequence")
	private BigDecimal txinSequence;

	@Column(name="txout_id")
	private BigDecimal txoutId;

	//bi-directional many-to-one association to BlockTxin
	@OneToMany(mappedBy="txin")
	private List<BlockTxin> blockTxins;

	//bi-directional many-to-one association to Tx
	@ManyToOne
	@JoinColumn(name="tx_id")
	private Tx tx;

	//bi-directional one-to-one association to UnlinkedTxin
	@OneToOne(mappedBy="txin")
	private UnlinkedTxin unlinkedTxin;

	public Txin() {
	}

	public long getTxinId() {
		return this.txinId;
	}

	public void setTxinId(long txinId) {
		this.txinId = txinId;
	}

	public BigDecimal getTxinPos() {
		return this.txinPos;
	}

	public void setTxinPos(BigDecimal txinPos) {
		this.txinPos = txinPos;
	}

	public String getTxinScriptsig() {
		return this.txinScriptsig;
	}

	public void setTxinScriptsig(String txinScriptsig) {
		this.txinScriptsig = txinScriptsig;
	}

	public BigDecimal getTxinSequence() {
		return this.txinSequence;
	}

	public void setTxinSequence(BigDecimal txinSequence) {
		this.txinSequence = txinSequence;
	}

	public BigDecimal getTxoutId() {
		return this.txoutId;
	}

	public void setTxoutId(BigDecimal txoutId) {
		this.txoutId = txoutId;
	}

	public List<BlockTxin> getBlockTxins() {
		return this.blockTxins;
	}

	public void setBlockTxins(List<BlockTxin> blockTxins) {
		this.blockTxins = blockTxins;
	}

	public Tx getTx() {
		return this.tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}

	public UnlinkedTxin getUnlinkedTxin() {
		return this.unlinkedTxin;
	}

	public void setUnlinkedTxin(UnlinkedTxin unlinkedTxin) {
		this.unlinkedTxin = unlinkedTxin;
	}

}