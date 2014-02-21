package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="chain_candidate")
@NamedQuery(name="ChainCandidate.findAll", query="SELECT c FROM ChainCandidate c")
public class ChainCandidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChainCandidatePK id;

	@Column(name="block_height")
	private BigDecimal blockHeight;

	@Column(name="in_longest")
	private BigDecimal inLongest;

	@ManyToOne
	@JoinColumn(name="block_id", insertable=false, updatable=false)
	private Block block;

	public ChainCandidate() {
	}

	public ChainCandidatePK getId() {
		return this.id;
	}

	public BigDecimal getBlockHeight() {
		return this.blockHeight;
	}

	public BigDecimal getInLongest() {
		return this.inLongest;
	}

	public Block getBlock() {
		return this.block;
	}
}