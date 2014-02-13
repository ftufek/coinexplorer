package org.coinexplorer.graph.nodes;

import org.coinexplorer.graph.GraphBatchInsert;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.schema.Schema;

public interface NBase<T> {
	public Node toNeoNode(Node node);
	public T fromNeoNode(Node node, Class<T> clazz);
	public GraphBatchInsert.BatchCapsule getBatchCapsule();
}
