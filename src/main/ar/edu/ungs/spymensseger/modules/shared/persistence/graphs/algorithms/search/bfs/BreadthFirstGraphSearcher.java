package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.bfs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.GraphSearcher;

import java.util.*;
import java.util.function.Consumer;

public final class BreadthFirstGraphSearcher<T, W extends Comparable> implements GraphSearcher<T, W> {
	@Override
	public void search(Graph<T, W> graph, Consumer<T> consumer) {
		search(graph, graph.random(), consumer);
	}

	@Override
	public void search(Graph<T, W> graph, T vertex, Consumer<T> consumer) {
		Queue<T> queue = new LinkedList<>();
		Map<T, Boolean> visited = new HashMap<>();

		for (var item: graph.vertexes()) {
			visited.put(item, false);
		}

		queue.add(vertex);

		while (!queue.isEmpty()) {
			T value = queue.poll();
			consumer.accept(value);

			visited.put(value, true);

			Set<T> neighbours = graph.neighbours(value);
			for (T neighbour : neighbours) {
				if (!visited.get(neighbour) && !queue.contains(neighbour)) {
					queue.add(neighbour);
				}
			}
		}
	}
}
