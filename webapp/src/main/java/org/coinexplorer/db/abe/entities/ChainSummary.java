package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chain_summary database table.
 * 
 */
@Entity
@Table(name="chain_summary")
@NamedQuery(name="ChainSummary.findAll", query="SELECT c FROM ChainSummary c")
public class ChainSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="block_chain_work")
	private String blockChainWork;

	@Column(name="block_hash")
	private String blockHash;

	@Column(name="block_hashmerkleroot")
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

	@Column(name="prev_block_hash")
	private String prevBlockHash;

	@Column(name="prev_block_id")
	private BigDecimal prevBlockId;

	public ChainSummary() {
	}

	public String getBlockChainWork() {
		return this.blockChainWork;
	}

	public void setBlockChainWork(String blockChainWork) {
		this.blockChainWork = blockChainWork;
	}

	public String getBlockHash() {
		return this.blockHash;
	}

	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}

	public String getBlockHashmerkleroot() {
		return this.blockHashmerkleroot;
	}

	public void setBlockHashmerkleroot(String blockHashmerkleroot) {
		this.blockHashmerkleroot = blockHashmerkleroot;
	}

	public BigDecimal getBlockHeight() {
		return this.blockHeight;
	}

	public void setBlockHeight(BigDecimal blockHeight) {
		this.blockHeight = blockHeight;
	}

	public BigDecimal getBlockId() {
		return this.blockId;
	}

	public void setBlockId(BigDecimal blockId) {
		this.blockId = blockId;
	}

	public BigDecimal getBlockNbits() {
		return this.blockNbits;
	}

	public void setBlockNbits(BigDecimal blockNbits) {
		this.blockNbits = blockNbits;
	}

	public BigDecimal getBlockNnonce() {
		return this.blockNnonce;
	}

	public void setBlockNnonce(BigDecimal blockNnonce) {
		this.blockNnonce = blockNnonce;
	}

	public BigDecimal getBlockNtime() {
		return this.blockNtime;
	}

	public void setBlockNtime(BigDecimal blockNtime) {
		this.blockNtime = blockNtime;
	}

	public BigDecimal getBlockNumTx() {
		return this.blockNumTx;
	}

	public void setBlockNumTx(BigDecimal blockNumTx) {
		this.blockNumTx = blockNumTx;
	}

	public BigDecimal getBlockSatoshiSeconds() {
		return this.blockSatoshiSeconds;
	}

	public void setBlockSatoshiSeconds(BigDecimal blockSatoshiSeconds) {
		this.blockSatoshiSeconds = blockSatoshiSeconds;
	}

	public BigDecimal getBlockSsDestroyed() {
		return this.blockSsDestroyed;
	}

	public void setBlockSsDestroyed(BigDecimal blockSsDestroyed) {
		this.blockSsDestroyed = blockSsDestroyed;
	}

	public BigDecimal getBlockTotalSatoshis() {
		return this.blockTotalSatoshis;
	}

	public void setBlockTotalSatoshis(BigDecimal blockTotalSatoshis) {
		this.blockTotalSatoshis = blockTotalSatoshis;
	}

	public BigDecimal getBlockTotalSeconds() {
		return this.blockTotalSeconds;
	}

	public void setBlockTotalSeconds(BigDecimal blockTotalSeconds) {
		this.blockTotalSeconds = blockTotalSeconds;
	}

	public BigDecimal getBlockTotalSs() {
		return this.blockTotalSs;
	}

	public void setBlockTotalSs(BigDecimal blockTotalSs) {
		this.blockTotalSs = blockTotalSs;
	}

	public BigDecimal getBlockValueIn() {
		return this.blockValueIn;
	}

	public void setBlockValueIn(BigDecimal blockValueIn) {
		this.blockValueIn = blockValueIn;
	}

	public BigDecimal getBlockValueOut() {
		return this.blockValueOut;
	}

	public void setBlockValueOut(BigDecimal blockValueOut) {
		this.blockValueOut = blockValueOut;
	}

	public BigDecimal getBlockVersion() {
		return this.blockVersion;
	}

	public void setBlockVersion(BigDecimal blockVersion) {
		this.blockVersion = blockVersion;
	}

	public BigDecimal getChainId() {
		return this.chainId;
	}

	public void setChainId(BigDecimal chainId) {
		this.chainId = chainId;
	}

	public BigDecimal getInLongest() {
		return this.inLongest;
	}

	public void setInLongest(BigDecimal inLongest) {
		this.inLongest = inLongest;
	}

	public String getPrevBlockHash() {
		return this.prevBlockHash;
	}

	public void setPrevBlockHash(String prevBlockHash) {
		this.prevBlockHash = prevBlockHash;
	}

	public BigDecimal getPrevBlockId() {
		return this.prevBlockId;
	}

	public void setPrevBlockId(BigDecimal prevBlockId) {
		this.prevBlockId = prevBlockId;
	}

}