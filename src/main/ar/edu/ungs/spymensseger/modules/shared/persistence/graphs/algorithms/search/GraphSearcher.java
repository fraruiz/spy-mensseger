package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;

import java.util.function.Consumer;

public interface GraphSearcher<T, W extends Comparable> {
	void search(Graph<T, W> graph, Consumer<T> consumer);

	void search(Graph<T, W> graph, T source, Consumer<T> consumer);
}
