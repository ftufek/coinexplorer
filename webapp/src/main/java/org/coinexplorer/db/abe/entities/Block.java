package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the block database table.
 * 
 */
@Entity
@NamedQuery(name="Block.findAll", query="SELECT b FROM Block b")
public class Block implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="block_id")
	private long blockId;

	@Column(name="block_chain_work")
	private String blockChainWork;

	@Column(name="block_hash")
	private String blockHash;

	@Column(name="block_hashmerkleroot")
	private String blockHashmerkleroot;

	@Column(name="block_height")
	private BigDecimal blockHeight;

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

	@OneToOne
	@JoinColumn(name="prev_block_id")
	private Block prevBlock;

	@OneToOne(mappedBy="prevBlock")
	private Block nextBlock;

	@OneToMany(mappedBy="block")
	private List<BlockTx> blockTxs;

	@OneToMany(mappedBy="block")
	private List<BlockTxin> blockTxins;

	@OneToMany(mappedBy="block")
	private List<Chain> chains;

	@OneToMany(mappedBy="block")
	private List<ChainCandidate> chainCandidates;

	@OneToOne(mappedBy="block")
	private OrphanBlock orphanBlock;

	public Block() {
	}

	public long getBlockId() {
		return this.blockId;
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

	public Block getBlock1() {
		return this.prevBlock;
	}

	public List<BlockTx> getBlockTxs() {
		return this.blockTxs;
	}

	public List<BlockTxin> getBlockTxins() {
		return this.blockTxins;
	}

	public List<Chain> getChains() {
		return this.chains;
	}

	public List<ChainCandidate> getChainCandidates() {
		return this.chainCandidates;
	}

	public OrphanBlock getOrphanBlock() {
		return this.orphanBlock;
	}
}