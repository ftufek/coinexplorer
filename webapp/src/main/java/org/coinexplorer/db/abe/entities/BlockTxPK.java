package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the block_tx database table.
 * 
 */
@Embeddable
public class BlockTxPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="block_id", insertable=false, updatable=false)
	private long blockId;

	@Column(name="tx_id", insertable=false, updatable=false)
	private long txId;

	public BlockTxPK() {
	}
	public long getBlockId() {
		return this.blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}
	public long getTxId() {
		return this.txId;
	}
	public void setTxId(long txId) {
		this.txId = txId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlockTxPK)) {
			return false;
		}
		BlockTxPK castOther = (BlockTxPK)other;
		return 
			(this.blockId == castOther.blockId)
			&& (this.txId == castOther.txId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.blockId ^ (this.blockId >>> 32)));
		hash = hash * prime + ((int) (this.txId ^ (this.txId >>> 32)));
		
		return hash;
	}
}