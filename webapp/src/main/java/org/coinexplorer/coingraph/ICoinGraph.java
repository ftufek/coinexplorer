package org.coinexplorer.coingraph;

import java.util.List;

import org.coinexplorer.graph.nodes.NTransaction;

public interface ICoinGraph {
	public void insertTransactions(List<NTransaction> tx);
}
