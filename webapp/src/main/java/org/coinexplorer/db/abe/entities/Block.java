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

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumn(name="prev_block_id")
	private Block block1;

	//bi-directional many-to-one association to Block
	@OneToMany(mappedBy="block1")
	private List<Block> blocks1;

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumn(name="search_block_id")
	private Block block2;

	//bi-directional many-to-one association to Block
	@OneToMany(mappedBy="block2")
	private List<Block> blocks2;

	//bi-directional many-to-many association to Block
	@ManyToMany
	@JoinTable(
		name="block_next"
		, joinColumns={
			@JoinColumn(name="next_block_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="block_id")
			}
		)
	private List<Block> blocks3;

	//bi-directional many-to-many association to Block
	@ManyToMany(mappedBy="blocks3")
	private List<Block> blocks4;

	//bi-directional many-to-one association to BlockTx
	@OneToMany(mappedBy="block")
	private List<BlockTx> blockTxs;

	//bi-directional many-to-one association to BlockTxin
	@OneToMany(mappedBy="block1")
	private List<BlockTxin> blockTxins1;

	//bi-directional many-to-one association to BlockTxin
	@OneToMany(mappedBy="block2")
	private List<BlockTxin> blockTxins2;

	//bi-directional many-to-one association to Chain
	@OneToMany(mappedBy="block")
	private List<Chain> chains;

	//bi-directional many-to-one association to ChainCandidate
	@OneToMany(mappedBy="block")
	private List<ChainCandidate> chainCandidates;

	//bi-directional one-to-one association to OrphanBlock
	@OneToOne(mappedBy="block")
	private OrphanBlock orphanBlock;

	public Block() {
	}

	public long getBlockId() {
		return this.blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
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

	public Block getBlock1() {
		return this.block1;
	}

	public void setBlock1(Block block1) {
		this.block1 = block1;
	}

	public List<Block> getBlocks1() {
		return this.blocks1;
	}

	public void setBlocks1(List<Block> blocks1) {
		this.blocks1 = blocks1;
	}

	public Block addBlocks1(Block blocks1) {
		getBlocks1().add(blocks1);
		blocks1.setBlock1(this);

		return blocks1;
	}

	public Block removeBlocks1(Block blocks1) {
		getBlocks1().remove(blocks1);
		blocks1.setBlock1(null);

		return blocks1;
	}

	public Block getBlock2() {
		return this.block2;
	}

	public void setBlock2(Block block2) {
		this.block2 = block2;
	}

	public List<Block> getBlocks2() {
		return this.blocks2;
	}

	public void setBlocks2(List<Block> blocks2) {
		this.blocks2 = blocks2;
	}

	public Block addBlocks2(Block blocks2) {
		getBlocks2().add(blocks2);
		blocks2.setBlock2(this);

		return blocks2;
	}

	public Block removeBlocks2(Block blocks2) {
		getBlocks2().remove(blocks2);
		blocks2.setBlock2(null);

		return blocks2;
	}

	public List<Block> getBlocks3() {
		return this.blocks3;
	}

	public void setBlocks3(List<Block> blocks3) {
		this.blocks3 = blocks3;
	}

	public List<Block> getBlocks4() {
		return this.blocks4;
	}

	public void setBlocks4(List<Block> blocks4) {
		this.blocks4 = blocks4;
	}

	public List<BlockTx> getBlockTxs() {
		return this.blockTxs;
	}

	public void setBlockTxs(List<BlockTx> blockTxs) {
		this.blockTxs = blockTxs;
	}

	public BlockTx addBlockTx(BlockTx blockTx) {
		getBlockTxs().add(blockTx);
		blockTx.setBlock(this);

		return blockTx;
	}

	public BlockTx removeBlockTx(BlockTx blockTx) {
		getBlockTxs().remove(blockTx);
		blockTx.setBlock(null);

		return blockTx;
	}

	public List<BlockTxin> getBlockTxins1() {
		return this.blockTxins1;
	}

	public void setBlockTxins1(List<BlockTxin> blockTxins1) {
		this.blockTxins1 = blockTxins1;
	}

	public BlockTxin addBlockTxins1(BlockTxin blockTxins1) {
		getBlockTxins1().add(blockTxins1);
		blockTxins1.setBlock1(this);

		return blockTxins1;
	}

	public BlockTxin removeBlockTxins1(BlockTxin blockTxins1) {
		getBlockTxins1().remove(blockTxins1);
		blockTxins1.setBlock1(null);

		return blockTxins1;
	}

	public List<BlockTxin> getBlockTxins2() {
		return this.blockTxins2;
	}

	public void setBlockTxins2(List<BlockTxin> blockTxins2) {
		this.blockTxins2 = blockTxins2;
	}

	public BlockTxin addBlockTxins2(BlockTxin blockTxins2) {
		getBlockTxins2().add(blockTxins2);
		blockTxins2.setBlock2(this);

		return blockTxins2;
	}

	public BlockTxin removeBlockTxins2(BlockTxin blockTxins2) {
		getBlockTxins2().remove(blockTxins2);
		blockTxins2.setBlock2(null);

		return blockTxins2;
	}

	public List<Chain> getChains() {
		return this.chains;
	}

	public void setChains(List<Chain> chains) {
		this.chains = chains;
	}

	public Chain addChain(Chain chain) {
		getChains().add(chain);
		chain.setBlock(this);

		return chain;
	}

	public Chain removeChain(Chain chain) {
		getChains().remove(chain);
		chain.setBlock(null);

		return chain;
	}

	public List<ChainCandidate> getChainCandidates() {
		return this.chainCandidates;
	}

	public void setChainCandidates(List<ChainCandidate> chainCandidates) {
		this.chainCandidates = chainCandidates;
	}

	public ChainCandidate addChainCandidate(ChainCandidate chainCandidate) {
		getChainCandidates().add(chainCandidate);
		chainCandidate.setBlock(this);

		return chainCandidate;
	}

	public ChainCandidate removeChainCandidate(ChainCandidate chainCandidate) {
		getChainCandidates().remove(chainCandidate);
		chainCandidate.setBlock(null);

		return chainCandidate;
	}

	public OrphanBlock getOrphanBlock() {
		return this.orphanBlock;
	}

	public void setOrphanBlock(OrphanBlock orphanBlock) {
		this.orphanBlock = orphanBlock;
	}

}