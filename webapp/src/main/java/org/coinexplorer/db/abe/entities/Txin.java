package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@NamedQuery(name="Txin.findAll", query="SELECT t FROM Txin t")
public class Txin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="txin_id")
	private BigDecimal txinId;

	@Column(name="txin_pos")
	private BigDecimal txinPos;

	@Column(name="txin_scriptsig")
	private String txinScriptsig;

	@Column(name="txin_sequence")
	private BigDecimal txinSequence;

	@Column(name="txout_id")
	private BigDecimal txoutId;

	@OneToMany(mappedBy="txin")
	private List<BlockTxin> blockTxins;

	@OneToOne
	@JoinColumn(name="tx_id")
	private Tx tx;

	public Txin() {
	}

	public BigDecimal getTxinId() {
		return this.txinId;
	}

	public BigDecimal getTxinPos() {
		return this.txinPos;
	}

	public String getTxinScriptsig() {
		return this.txinScriptsig;
	}

	public BigDecimal getTxinSequence() {
		return this.txinSequence;
	}

	public BigDecimal getTxoutId() {
		return this.txoutId;
	}

	public List<BlockTxin> getBlockTxins() {
		return this.blockTxins;
	}

	public Tx getTx() {
		return this.tx;
	}
}