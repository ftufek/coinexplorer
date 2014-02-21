package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="txin_detail")
@NamedQuery(name="TxinDetail.findAll", query="SELECT t FROM TxinDetail t")
public class TxinDetail implements Serializable {
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

	@Column(name="prevout_id")
	private BigDecimal prevoutId;

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

	@Column(name="txin_id")
	private BigDecimal txinId;

	@Column(name="txin_pos")
	private BigDecimal txinPos;

	@Column(name="txin_scriptsig")
	private String txinScriptsig;

	@Column(name="txin_sequence")
	private BigDecimal txinSequence;

	@Column(name="txin_value")
	private BigDecimal txinValue;

	public TxinDetail() {
	}

	public String getBlockHash() {
		return this.blockHash;
	}

	public BigDecimal getBlockHeight() {
		return this.blockHeight;
	}

	public BigDecimal getBlockId() {
		return this.blockId;
	}

	public BigDecimal getChainId() {
		return this.chainId;
	}

	public BigDecimal getInLongest() {
		return this.inLongest;
	}

	public BigDecimal getPrevoutId() {
		return this.prevoutId;
	}

	public String getPubkey() {
		return this.pubkey;
	}

	public String getPubkeyHash() {
		return this.pubkeyHash;
	}

	public BigDecimal getPubkeyId() {
		return this.pubkeyId;
	}

	public String getTxHash() {
		return this.txHash;
	}

	public BigDecimal getTxId() {
		return this.txId;
	}

	public BigDecimal getTxLocktime() {
		return this.txLocktime;
	}

	public BigDecimal getTxPos() {
		return this.txPos;
	}

	public BigDecimal getTxSize() {
		return this.txSize;
	}

	public BigDecimal getTxVersion() {
		return this.txVersion;
	}

	public BigDecimal getTxinId() {
		return this.txinId;
	}

	public BigDecimal getTxinPos() {
		return this.txinPos;
	}

	public String getTxinScriptsig() {
		return this.txinScriptsig;
	}

	public BigDecimal getTxinSequence() {
		return this.txinSequence;
	}

	public BigDecimal getTxinValue() {
		return this.txinValue;
	}
}