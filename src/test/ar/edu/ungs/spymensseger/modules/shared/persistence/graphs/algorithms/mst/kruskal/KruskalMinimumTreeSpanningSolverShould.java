package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.mst.kruskal;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.mst.prim.PrimMinimumTreeSpanningSolver;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

final class KruskalMinimumTreeSpanningSolverShould {
	private KruskalMinimumTreeSpanningSolver<Integer, Double> solver;

	@BeforeEach
	void setUp() {
		this.solver = new KruskalMinimumTreeSpanningSolver<Integer, Double>();
	}
}