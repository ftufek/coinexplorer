package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orphan_block database table.
 * 
 */
@Entity
@Table(name="orphan_block")
@NamedQuery(name="OrphanBlock.findAll", query="SELECT o FROM OrphanBlock o")
public class OrphanBlock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="block_id")
	private long blockId;

	@Column(name="block_hashprev")
	private String blockHashprev;

	//bi-directional one-to-one association to Block
	@OneToOne
	@JoinColumn(name="block_id")
	private Block block;

	public OrphanBlock() {
	}

	public long getBlockId() {
		return this.blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public String getBlockHashprev() {
		return this.blockHashprev;
	}

	public void setBlockHashprev(String blockHashprev) {
		this.blockHashprev = blockHashprev;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}