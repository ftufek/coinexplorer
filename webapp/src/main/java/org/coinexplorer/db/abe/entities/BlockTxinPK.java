package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BlockTxinPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="block_id", insertable=false, updatable=false)
	private BigDecimal blockId;

	@Column(name="txin_id", insertable=false, updatable=false)
	private BigDecimal txinId;

	public BlockTxinPK() {
	}
	public BigDecimal getBlockId() {
		return this.blockId;
	}
	
	public BigDecimal getTxinId() {
		return this.txinId;
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
		hash = hash * prime + this.blockId.hashCode();
		hash = hash * prime + this.txinId.hashCode();
		
		return hash;
	}
}