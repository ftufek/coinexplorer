package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChainCandidatePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="chain_id")
	private BigDecimal chainId;

	@Column(name="block_id", insertable=false, updatable=false)
	private BigDecimal blockId;

	public ChainCandidatePK() {
	}
	public BigDecimal getChainId() {
		return this.chainId;
	}
	
	public BigDecimal getBlockId() {
		return this.blockId;
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
		hash = hash * prime + this.chainId.hashCode();
		hash = hash * prime + this.blockId.hashCode();
		
		return hash;
	}
}