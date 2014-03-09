package org.coinexplorer.coingraph;

import java.util.List;

import org.coinexplorer.coingraph.nodes.NTransaction;

public interface CoinGraph {
	/**
	 * Inserts multiple transaction nodes into neo4j.
	 * 
	 * @param tx list of transactions
	 */
	public void insertTransactions(List<NTransaction> tx);
	
	/**
	 * Returns the transaction id from where the previous
	 * indexation was left off. So that when continuing the
	 * syncronization with psql, we don't have to start from
	 * beginning.
	 * The transaction id where we left off is stored in neo4j.
	 */
	public int getContinuationTxId();
	
	public void setContinuationTxId(int tx_id);
}
