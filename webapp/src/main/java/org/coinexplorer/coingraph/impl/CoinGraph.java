package org.coinexplorer.coingraph.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.coinexplorer.coingraph.ICoinGraph;
import org.coinexplorer.config.CEConfig;
import org.coinexplorer.graph.nodes.NLabel;
import org.coinexplorer.graph.nodes.NTransaction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.UniqueFactory;

@ApplicationScoped
public class CoinGraph implements ICoinGraph {
	@Inject
	CEConfig config;
	
	private GraphDatabaseService graphDb;
	
	@PostConstruct
	public void init(){
		this.graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(config.getGraphDbPath());
		new CoinGraphMigrations(graphDb).run();
	}
	
	@PreDestroy
	public void destroy(){
		graphDb.shutdown();
	}

	@Override
	public void insertTransactions(List<NTransaction> txNodes) {
		try(Transaction tx = graphDb.beginTx()){
			UniqueFactory.UniqueNodeFactory factory = new UniqueFactory.UniqueNodeFactory(graphDb, "address") {
				@Override
				protected void initialize(Node created, Map<String, Object> properties) {
					created.addLabel(NLabel.Address);
					created.setProperty("address", properties.get("address"));
				}
			};
			for(NTransaction txNode : txNodes){
				for(String address : txNode.getOutAddresses()){
					factory.getOrCreate("address", address);
				}
			}
			tx.success();
		}
	}
}
