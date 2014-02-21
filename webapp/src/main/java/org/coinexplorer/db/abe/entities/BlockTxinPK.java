package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the block_txin database table.
 * 
 */
@Embeddable
public class BlockTxinPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="block_id", insertable=false, updatable=false)
	private long blockId;

	@Column(name="txin_id", insertable=false, updatable=false)
	private long txinId;

	public BlockTxinPK() {
	}
	public long getBlockId() {
		return this.blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}
	public long getTxinId() {
		return this.txinId;
	}
	public void setTxinId(long txinId) {
		this.txinId = txinId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlockTxinPK)) {
			return false;
		}
		BlockTxinPK castOther = (BlockTxinPK)other;
		return 
			(this.blockId == castOther.blockId)
			&& (this.txinId == castOther.txinId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.blockId ^ (this.blockId >>> 32)));
		hash = hash * prime + ((int) (this.txinId ^ (this.txinId >>> 32)));
		
		return hash;
	}
}