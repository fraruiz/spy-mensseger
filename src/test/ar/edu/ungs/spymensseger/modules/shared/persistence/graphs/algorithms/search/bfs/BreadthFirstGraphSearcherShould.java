package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.search.bfs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.GraphMother;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class BreadthFirstGraphSearcherShould {
	private BreadthFirstGraphSearcher<Integer, Double> searcher;

	@BeforeEach
	void setUp() {
		this.searcher = new BreadthFirstGraphSearcher<>();
	}

	@Test
	void search_all_vertexes() {
		Graph<Integer, Double> graph = GraphMother.random();

		List<Integer> expected = List.of(0, 1, 3, 4, 2, 5);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, 0, actual::add);

		assertEquals(expected, actual);
	}
}