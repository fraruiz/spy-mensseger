package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.bfs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.AdjacencyMatrixGraph;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import ar.edu.ungs.spymensseger.shared.domain.DoubleMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class BreadthFirstGraphSearcherShould {
	private BreadthFirstGraphSearcher<Integer> searcher;

	@BeforeEach
	void setUp() {
		this.searcher = new BreadthFirstGraphSearcher<Integer>();
	}

	@Test
	void search_all_vertexes() {
		Graph<Integer> graph = buildGraph();

		List<Integer> expected = List.of(0, 1, 3, 4, 2, 5);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, 0, actual::add);

		assertEquals(expected, actual);
	}

	private Graph<Integer> buildGraph() {
		Graph<Integer> graph = new AdjacencyMatrixGraph<>(6);

		graph.add(0, 1, DoubleMother.random(0D, 1D));
		graph.add(0, 3, DoubleMother.random(0D, 1D));
		graph.add(0, 4, DoubleMother.random(0D, 1D));
		graph.add(4, 5, DoubleMother.random(0D, 1D));
		graph.add(3, 5, DoubleMother.random(0D, 1D));
		graph.add(1, 2, DoubleMother.random(0D, 1D));
		graph.add(1, 0, DoubleMother.random(0D, 1D));
		graph.add(2, 1, DoubleMother.random(0D, 1D));
		graph.add(4, 1, DoubleMother.random(0D, 1D));
		graph.add(3, 1, DoubleMother.random(0D, 1D));
		graph.add(5, 4, DoubleMother.random(0D, 1D));
		graph.add(5, 3, DoubleMother.random(0D, 1D));

		return graph;
	}
}