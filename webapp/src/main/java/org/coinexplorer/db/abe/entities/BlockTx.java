package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the block_tx database table.
 * 
 */
@Entity
@Table(name="block_tx")
@NamedQuery(name="BlockTx.findAll", query="SELECT b FROM BlockTx b")
public class BlockTx implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlockTxPK id;

	@Column(name="tx_pos")
	private BigDecimal txPos;

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumn(name="block_id")
	private Block block;

	//bi-directional many-to-one association to Tx
	@ManyToOne
	@JoinColumn(name="tx_id")
	private Tx tx;

	public BlockTx() {
	}

	public BlockTxPK getId() {
		return this.id;
	}

	public void setId(BlockTxPK id) {
		this.id = id;
	}

	public BigDecimal getTxPos() {
		return this.txPos;
	}

	public void setTxPos(BigDecimal txPos) {
		this.txPos = txPos;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Tx getTx() {
		return this.tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}

}