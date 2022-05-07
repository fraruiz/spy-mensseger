package ar.edu.ungs.spymensseger.modules.networks.application.mst;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleUnitTestCase;
import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkResponse;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.spymensseger.modules.networks.domain.find.CommunicationNetworkFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MinimumCommunicationNetworkSpanningSearcherShould extends CommunicationNetworksModuleUnitTestCase {
	private MinimumCommunicationNetworkSpanningSearcher searcher;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();

		CommunicationNetworkFinder finder = new CommunicationNetworkFinder(repository);
		this.searcher = new MinimumCommunicationNetworkSpanningSearcher(finder, minimumCommunicationNetworkSpanningSolver);
	}

	@Test
	void find_a_communication_network_and_generate_minimum_communication_network_spanning() {
		CommunicationNetwork undirectedNetwork = CommunicationNetworkMother.undirectedRandom();
		CommunicationNetwork minimumNetwork = CommunicationNetworkMother.minimumRandom();
		CommunicationNetworkResponse expected = CommunicationNetworkResponse.map(minimumNetwork);

		shouldFind(undirectedNetwork);
		shouldSolveMinimumCommunicationNetworkSpanning(undirectedNetwork, minimumNetwork);

		CommunicationNetworkResponse actual = searcher.search();

		assertEquals(expected, actual);
	}
}