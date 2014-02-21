package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BlockTxPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="block_id", insertable=false, updatable=false)
	private BigDecimal blockId;

	@Column(name="tx_id", insertable=false, updatable=false)
	private BigDecimal txId;

	public BlockTxPK() {
	}
	
	public BigDecimal getBlockId() {
		return this.blockId;
	}
	
	public BigDecimal getTxId() {
		return this.txId;
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
		hash = hash * prime + this.blockId.hashCode();
		hash = hash * prime + this.txId.hashCode();
		return hash;
	}
}