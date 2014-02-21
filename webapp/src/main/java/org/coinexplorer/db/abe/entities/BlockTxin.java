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

	@MapsId("block_id") @ManyToOne
	private Block block1;

	@ManyToOne
	@JoinColumn(name="out_block_id")
	private Block block2;

	@MapsId("txin_id") @ManyToOne
	private Txin txin;

	public BlockTxin() {
	}

	public BlockTxinPK getId() {
		return this.id;
	}

	public Block getBlock1() {
		return this.block1;
	}

	public Block getBlock2() {
		return this.block2;
	}

	public Txin getTxin() {
		return this.txin;
	}
}