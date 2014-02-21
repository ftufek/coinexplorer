package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chain_candidate database table.
 * 
 */
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

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumn(name="block_id")
	private Block block;

	public ChainCandidate() {
	}

	public ChainCandidatePK getId() {
		return this.id;
	}

	public void setId(ChainCandidatePK id) {
		this.id = id;
	}

	public BigDecimal getBlockHeight() {
		return this.blockHeight;
	}

	public void setBlockHeight(BigDecimal blockHeight) {
		this.blockHeight = blockHeight;
	}

	public BigDecimal getInLongest() {
		return this.inLongest;
	}

	public void setInLongest(BigDecimal inLongest) {
		this.inLongest = inLongest;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}