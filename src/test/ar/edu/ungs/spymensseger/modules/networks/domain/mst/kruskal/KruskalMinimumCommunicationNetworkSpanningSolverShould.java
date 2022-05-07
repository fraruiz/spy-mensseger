package ar.edu.ungs.spymensseger.modules.networks.domain.mst.kruskal;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.spymensseger.modules.networks.domain.mst.MinimumCommunicationNetworkSpanningSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class KruskalMinimumCommunicationNetworkSpanningSolverShould {
	private MinimumCommunicationNetworkSpanningSolver solver;

	@BeforeEach
	void setUp() {
		this.solver = new KruskalMinimumCommunicationNetworkSpanningSolver();
	}

	@Test
	void solve_minimum_communication_network_spanning() {
		CommunicationNetwork network = CommunicationNetworkMother.minimumRandom();
		CommunicationNetwork expected = CommunicationNetworkMother.undirectedRandom();

		CommunicationNetwork actual = this.solver.solve(network);

		assertEquals(expected, actual);
	}
}