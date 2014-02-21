package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the chain database table.
 * 
 */
@Entity
@NamedQuery(name="Chain.findAll", query="SELECT c FROM Chain c")
public class Chain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chain_id")
	private long chainId;

	@Column(name="chain_address_version")
	private String chainAddressVersion;

	@Column(name="chain_code3")
	private String chainCode3;

	@Column(name="chain_decimals")
	private BigDecimal chainDecimals;

	@Column(name="chain_magic")
	private String chainMagic;

	@Column(name="chain_name")
	private String chainName;

	@Column(name="chain_policy")
	private String chainPolicy;

	//bi-directional many-to-one association to Block
	@ManyToOne
	@JoinColumn(name="chain_last_block_id")
	private Block block;

	public Chain() {
	}

	public long getChainId() {
		return this.chainId;
	}

	public void setChainId(long chainId) {
		this.chainId = chainId;
	}

	public String getChainAddressVersion() {
		return this.chainAddressVersion;
	}

	public void setChainAddressVersion(String chainAddressVersion) {
		this.chainAddressVersion = chainAddressVersion;
	}

	public String getChainCode3() {
		return this.chainCode3;
	}

	public void setChainCode3(String chainCode3) {
		this.chainCode3 = chainCode3;
	}

	public BigDecimal getChainDecimals() {
		return this.chainDecimals;
	}

	public void setChainDecimals(BigDecimal chainDecimals) {
		this.chainDecimals = chainDecimals;
	}

	public String getChainMagic() {
		return this.chainMagic;
	}

	public void setChainMagic(String chainMagic) {
		this.chainMagic = chainMagic;
	}

	public String getChainName() {
		return this.chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	public String getChainPolicy() {
		return this.chainPolicy;
	}

	public void setChainPolicy(String chainPolicy) {
		this.chainPolicy = chainPolicy;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}