package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.bfs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.GraphSearcher;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class BreadthFirstGraphSearcher<T> implements GraphSearcher<T> {
	@Override
	public void search(Graph<T> graph, Integer source, Consumer<Integer> consumer) {
		boolean[] visited = new boolean[graph.size()];

		Queue<Integer> queue = new LinkedList<>();

		queue.add(source);

		while (!queue.isEmpty()) {
			Integer vertex = queue.poll();
			consumer.accept(vertex);
			visited[vertex] = true;

			Set<Integer> neighbours = graph.neighbours(vertex);
			for (Integer neighbour : neighbours) {
				if (!visited[neighbour] && !queue.contains(neighbour)) {
					queue.add(neighbour);
				}
			}
		}
	}
}
