package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chain_candidate database table.
 * 
 */
@Embeddable
public class ChainCandidatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="chain_id")
	private long chainId;

	@Column(name="block_id", insertable=false, updatable=false)
	private long blockId;

	public ChainCandidatePK() {
	}
	public long getChainId() {
		return this.chainId;
	}
	public void setChainId(long chainId) {
		this.chainId = chainId;
	}
	public long getBlockId() {
		return this.blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChainCandidatePK)) {
			return false;
		}
		ChainCandidatePK castOther = (ChainCandidatePK)other;
		return 
			(this.chainId == castOther.chainId)
			&& (this.blockId == castOther.blockId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.chainId ^ (this.chainId >>> 32)));
		hash = hash * prime + ((int) (this.blockId ^ (this.blockId >>> 32)));
		
		return hash;
	}
}