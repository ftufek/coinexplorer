package org.coinexplorer.db.abe.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Pubkey.findAll", query="SELECT p FROM Pubkey p")
public class Pubkey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pubkey_id")
	private BigDecimal pubkeyId;

	@Column(name="pubkey", columnDefinition="bpchar(130)")
	private String pubkey;

	@Column(name="pubkey_hash", columnDefinition="bpchar(40)")
	private String pubkeyHash;

	@OneToMany(mappedBy="pubkey")
	private List<Txout> txouts;

	public Pubkey() {
	}

	public BigDecimal getPubkeyId() {
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