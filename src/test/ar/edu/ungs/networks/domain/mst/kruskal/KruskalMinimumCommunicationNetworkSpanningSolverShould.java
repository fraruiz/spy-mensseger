package ar.edu.ungs.networks.domain.mst.kruskal;

import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.CommunicationNetworkMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class KruskalMinimumCommunicationNetworkSpanningSolverShould {
	private KruskalMinimumCommunicationNetworkSpanningSolver solver;

	@BeforeEach
	void setUp() {
		this.solver = new KruskalMinimumCommunicationNetworkSpanningSolver();
	}

	@Test
	void solve_minimum_communication_network_spanning() {
		CommunicationNetwork network = CommunicationNetworkMother.undirectedRandom();
		CommunicationNetwork expected = CommunicationNetworkMother.minimumRandom();

		CommunicationNetwork actual = this.solver.solve(network);

		assertEquals(expected, actual);
	}
}