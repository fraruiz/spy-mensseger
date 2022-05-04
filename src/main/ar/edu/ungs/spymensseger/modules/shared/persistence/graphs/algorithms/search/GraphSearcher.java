package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;

import java.util.function.Consumer;

public interface GraphSearcher<T> {
	void search(Graph<T> graph, Integer source, Consumer<Integer> consumer);
}
