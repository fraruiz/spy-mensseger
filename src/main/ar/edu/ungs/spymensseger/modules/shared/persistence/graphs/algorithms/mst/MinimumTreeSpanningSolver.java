package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.mst;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;

public interface MinimumTreeSpanningSolver<T> {
	Graph<T> solve(Graph<T> graph);
}
