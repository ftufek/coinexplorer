package org.coinexplorer.graph.nodes;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.schema.Schema;

public interface NBase {
	public Node fillNode(Node node);
}
