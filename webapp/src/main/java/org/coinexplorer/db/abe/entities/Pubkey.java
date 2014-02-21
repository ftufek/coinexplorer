package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

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

	@OneToMany(mappedBy="pubkey")
	private List<Txout> txouts;

	public Pubkey() {
	}

	public long getPubkeyId() {
		return this.pubkeyId;
	}

	public String getPubkey() {
		return this.pubkey;
	}

	public String getPubkeyHash() {
		return this.pubkeyHash;
	}

	public List<Txout> getTxouts() {
		return this.txouts;
	}
}