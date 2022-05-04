package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleInfrastructureTestCase;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class GraphCommunicationNetworkRepositoryShould extends CommunicationNetworksModuleInfrastructureTestCase {
	private GraphCommunicationNetworkRepository graphRepository;

	@BeforeEach
	void setUp() {
		this.graphRepository = new GraphCommunicationNetworkRepository();
	}

	@Test
	void save_a_communication_network() {
		CommunicationNetwork expected = CommunicationNetworkMother.random();

		graphRepository.save(expected);
	}

	//@Test
	void find_a_communication_network() {
		CommunicationNetwork expected = CommunicationNetworkMother.random();

		graphRepository.save(expected);

		Optional<CommunicationNetwork> actual = graphRepository.find();

		assertTrue(actual.isPresent());
		assertEquals(expected, actual.get());
	}

	@Test
	void find_empty_communication_network_when_not_exists() {
		Optional<CommunicationNetwork> actual = graphRepository.find();

		assertTrue(actual.isEmpty());
	}
}