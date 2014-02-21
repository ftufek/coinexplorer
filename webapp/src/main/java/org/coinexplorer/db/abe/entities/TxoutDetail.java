package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the txout_detail database table.
 * 
 */
@Entity
@Table(name="txout_detail")
@NamedQuery(name="TxoutDetail.findAll", query="SELECT t FROM TxoutDetail t")
public class TxoutDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="block_hash")
	private String blockHash;

	@Column(name="block_height")
	private BigDecimal blockHeight;

	@Column(name="block_id")
	private BigDecimal blockId;

	@Column(name="chain_id")
	private BigDecimal chainId;

	@Column(name="in_longest")
	private BigDecimal inLongest;

	private String pubkey;

	@Column(name="pubkey_hash")
	private String pubkeyHash;

	@Column(name="pubkey_id")
	private BigDecimal pubkeyId;

	@Column(name="tx_hash")
	private String txHash;

	@Id
	@Column(name="tx_id")
	private BigDecimal txId;

	@Column(name="tx_locktime")
	private BigDecimal txLocktime;

	@Column(name="tx_pos")
	private BigDecimal txPos;

	@Column(name="tx_size")
	private BigDecimal txSize;

	@Column(name="tx_version")
	private BigDecimal txVersion;

	@Column(name="txout_id")
	private BigDecimal txoutId;

	@Column(name="txout_pos")
	private BigDecimal txoutPos;

	@Column(name="txout_scriptpubkey")
	private String txoutScriptpubkey;

	@Column(name="txout_value")
	private BigDecimal txoutValue;

	public TxoutDetail() {
	}

	public String getBlockHash() {
		return this.blockHash;
	}

	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
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

	public String getPubkey() {
		return this.pubkey;
	}

	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	public String getPubkeyHash() {
		return this.pubkeyHash;
	}

	public void setPubkeyHash(String pubkeyHash) {
		this.pubkeyHash = pubkeyHash;
	}

	public BigDecimal getPubkeyId() {
		return this.pubkeyId;
	}

	public void setPubkeyId(BigDecimal pubkeyId) {
		this.pubkeyId = pubkeyId;
	}

	public String getTxHash() {
		return this.txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public void setTxId(BigDecimal txId) {
		this.txId = txId;
	}

	public BigDecimal getTxLocktime() {
		return this.txLocktime;
	}

	public void setTxLocktime(BigDecimal txLocktime) {
		this.txLocktime = txLocktime;
	}

	public BigDecimal getTxPos() {
		return this.txPos;
	}

	public void setTxPos(BigDecimal txPos) {
		this.txPos = txPos;
	}

	public BigDecimal getTxSize() {
		return this.txSize;
	}

	public void setTxSize(BigDecimal txSize) {
		this.txSize = txSize;
	}

	public BigDecimal getTxVersion() {
		return this.txVersion;
	}

	public void setTxVersion(BigDecimal txVersion) {
		this.txVersion = txVersion;
	}

	public BigDecimal getTxoutId() {
		return this.txoutId;
	}

	public void setTxoutId(BigDecimal txoutId) {
		this.txoutId = txoutId;
	}

	public BigDecimal getTxoutPos() {
		return this.txoutPos;
	}

	public void setTxoutPos(BigDecimal txoutPos) {
		this.txoutPos = txoutPos;
	}

	public String getTxoutScriptpubkey() {
		return this.txoutScriptpubkey;
	}

	public void setTxoutScriptpubkey(String txoutScriptpubkey) {
		this.txoutScriptpubkey = txoutScriptpubkey;
	}

	public BigDecimal getTxoutValue() {
		return this.txoutValue;
	}

	public void setTxoutValue(BigDecimal txoutValue) {
		this.txoutValue = txoutValue;
	}

}