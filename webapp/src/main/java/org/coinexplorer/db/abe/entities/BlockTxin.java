package org.coinexplorer.db.abe.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.jboss.resteasy.annotations.cache.NoCache;


/**
 * The persistent class for the block_txin database table.
 * 
 */
@Entity
@Table(name="block_txin")
@NamedQuery(name="BlockTxin.findAll", query="SELECT b FROM BlockTxin b")
public class BlockTxin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlockTxinPK id;

	@JoinColumn(name="block_id") @ManyToOne
	private Block block;

	@ManyToOne
	@JoinColumn(name="out_block_id")
	private Block outBlock;

	@JoinColumn(name="txin_id") @ManyToOne
	private Txin txin;

	public BlockTxin() {
	}

	public BlockTxinPK getId() {
		return this.id;
	}

	public Block getBlock() {
		return this.block;
	}

	public Block getOutBlock() {
		return this.outBlock;
	}

	public Txin getTxin() {
		return this.txin;
	}
}