package ar.edu.ungs.spymensseger.modules.networks.domain.mst.prim;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class PrimMinimumCommunicationNetworkSpanningSolverShould {
	private PrimMinimumCommunicationNetworkSpanningSolver solver;

	@BeforeEach
	void setUp() {
		this.solver = new PrimMinimumCommunicationNetworkSpanningSolver();
	}

	@Test
	void solve_minimum_communication_network_spanning() {
		CommunicationNetwork network = CommunicationNetworkMother.undirectedRandom();
		CommunicationNetwork expected = CommunicationNetworkMother.minimumRandom();

		CommunicationNetwork actual = this.solver.solve(network);

		assertEquals(expected, actual);
	}
}
