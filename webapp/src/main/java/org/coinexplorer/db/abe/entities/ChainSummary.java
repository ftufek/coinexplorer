package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="chain_summary")
@NamedQuery(name="ChainSummary.findAll", query="SELECT c FROM ChainSummary c")
public class ChainSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="block_chain_work", columnDefinition="bpchar(76)")
	private String blockChainWork;

	@Column(name="block_hash", columnDefinition="bpchar(64)")
	private String blockHash;

	@Column(name="block_hashmerkleroot", columnDefinition="bpchar(64)")
	private String blockHashmerkleroot;

	@Column(name="block_height")
	private BigDecimal blockHeight;

	@Column(name="block_id")
	private BigDecimal blockId;

	@Column(name="block_nbits")
	private BigDecimal blockNbits;

	@Column(name="block_nnonce")
	private BigDecimal blockNnonce;

	@Column(name="block_ntime")
	private BigDecimal blockNtime;

	@Column(name="block_num_tx")
	private BigDecimal blockNumTx;

	@Column(name="block_satoshi_seconds")
	private BigDecimal blockSatoshiSeconds;

	@Column(name="block_ss_destroyed")
	private BigDecimal blockSsDestroyed;

	@Column(name="block_total_satoshis")
	private BigDecimal blockTotalSatoshis;

	@Column(name="block_total_seconds")
	private BigDecimal blockTotalSeconds;

	@Column(name="block_total_ss")
	private BigDecimal blockTotalSs;

	@Column(name="block_value_in")
	private BigDecimal blockValueIn;

	@Column(name="block_value_out")
	private BigDecimal blockValueOut;

	@Column(name="block_version")
	private BigDecimal blockVersion;

	@Id
	@Column(name="chain_id")
	private BigDecimal chainId;

	@Column(name="in_longest")
	private BigDecimal inLongest;

	@Column(name="prev_block_hash", columnDefinition="bpchar(64)")
	private String prevBlockHash;

	@Column(name="prev_block_id")
	private BigDecimal prevBlockId;

	public ChainSummary() {
	}

	public String getBlockChainWork() {
		return this.blockChainWork;
	}

	public String getBlockHash() {
		return this.blockHash;
	}

	public String getBlockHashmerkleroot() {
		return this.blockHashmerkleroot;
	}

	public BigDecimal getBlockHeight() {
		return this.blockHeight;
	}

	public BigDecimal getBlockId() {
		return this.blockId;
	}
	
	public BigDecimal getBlockNbits() {
		return this.blockNbits;
	}

	public BigDecimal getBlockNnonce() {
		return this.blockNnonce;
	}

	public BigDecimal getBlockNtime() {
		return this.blockNtime;
	}

	public BigDecimal getBlockNumTx() {
		return this.blockNumTx;
	}

	public BigDecimal getBlockSatoshiSeconds() {
		return this.blockSatoshiSeconds;
	}

	public BigDecimal getBlockSsDestroyed() {
		return this.blockSsDestroyed;
	}

	public BigDecimal getBlockTotalSatoshis() {
		return this.blockTotalSatoshis;
	}

	public BigDecimal getBlockTotalSeconds() {
		return this.blockTotalSeconds;
	}

	public BigDecimal getBlockTotalSs() {
		return this.blockTotalSs;
	}

	public BigDecimal getBlockValueIn() {
		return this.blockValueIn;
	}

	public BigDecimal getBlockValueOut() {
		return this.blockValueOut;
	}

	public BigDecimal getBlockVersion() {
		return this.blockVersion;
	}

	public BigDecimal getChainId() {
		return this.chainId;
	}

	public BigDecimal getInLongest() {
		return this.inLongest;
	}

	public String getPrevBlockHash() {
		return this.prevBlockHash;
	}

	public BigDecimal getPrevBlockId() {
		return this.prevBlockId;
	}
}