package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="block_tx")
@NamedQuery(name="BlockTx.findAll", query="SELECT b FROM BlockTx b")
public class BlockTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlockTxPK id;

	@Column(name="tx_pos")
	private BigDecimal txPos;

	@ManyToOne
	@JoinColumn(name="block_id", insertable=false, updatable=false)
	private Block block;

	@ManyToOne
	@JoinColumn(name="tx_id", insertable=false, updatable=false)
	private Tx tx;

	public BlockTx() {
	}

	public BlockTxPK getId() {
		return this.id;
	}

	public BigDecimal getTxPos() {
		return this.txPos;
	}

	public Block getBlock() {
		return this.block;
	}

	public Tx getTx() {
		return this.tx;
	}
}