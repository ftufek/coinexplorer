package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="orphan_block")
@NamedQuery(name="OrphanBlock.findAll", query="SELECT o FROM OrphanBlock o")
public class OrphanBlock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="block_id")
	private BigDecimal blockId;

	@Column(name="block_hashprev", columnDefinition="bpchar(64)")
	private String blockHashprev;

	@OneToOne
	@JoinColumn(name="block_id")
	private Block block;

	public OrphanBlock() {
	}

	public BigDecimal getBlockId() {
		return this.blockId;
	}

	public String getBlockHashprev() {
		return this.blockHashprev;
	}

	public Block getBlock() {
		return this.block;
	}
}