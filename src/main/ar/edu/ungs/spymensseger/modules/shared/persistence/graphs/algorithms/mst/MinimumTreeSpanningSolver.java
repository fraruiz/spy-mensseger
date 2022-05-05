package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.mst;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;

public interface MinimumTreeSpanningSolver<V, W extends Comparable> {
	Graph<V, W> solve(Graph<V, W> graph);
}
