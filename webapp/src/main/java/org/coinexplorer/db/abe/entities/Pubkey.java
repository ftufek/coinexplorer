package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pubkey database table.
 * 
 */
@Entity
@NamedQuery(name="Pubkey.findAll", query="SELECT p FROM Pubkey p")
public class Pubkey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pubkey_id")
	private long pubkeyId;

	private String pubkey;

	@Column(name="pubkey_hash")
	private String pubkeyHash;

	//bi-directional many-to-one association to Txout
	@OneToMany(mappedBy="pubkey")
	private List<Txout> txouts;

	public Pubkey() {
	}

	public long getPubkeyId() {
		return this.pubkeyId;
	}

	public void setPubkeyId(long pubkeyId) {
		this.pubkeyId = pubkeyId;
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

	public List<Txout> getTxouts() {
		return this.txouts;
	}

	public void setTxouts(List<Txout> txouts) {
		this.txouts = txouts;
	}

	public Txout addTxout(Txout txout) {
		getTxouts().add(txout);
		txout.setPubkey(this);

		return txout;
	}

	public Txout removeTxout(Txout txout) {
		getTxouts().remove(txout);
		txout.setPubkey(null);

		return txout;
	}

}