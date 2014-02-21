package org.coinexplorer.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.coinexplorer.db.abe.entities.Block;

@Stateless
public class BitcoinService {
	@PersistenceContext EntityManager em;
	
	public Block getBlock(int id){
		return null;
	}
}
