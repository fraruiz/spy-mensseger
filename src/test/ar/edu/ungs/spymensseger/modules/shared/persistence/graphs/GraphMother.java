package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import ar.edu.ungs.spymensseger.shared.domain.DoubleMother;

import java.util.Set;

public final class GraphMother {
	public static Graph<Integer, Double> random() {
		Graph<Integer, Double> graph = new Graph<>(Set.of(0, 1, 2, 3, 4, 5));

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
