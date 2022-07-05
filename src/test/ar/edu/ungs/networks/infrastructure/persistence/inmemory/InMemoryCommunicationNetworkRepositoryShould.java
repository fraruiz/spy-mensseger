package ar.edu.ungs.networks.infrastructure.persistence.inmemory;

import ar.edu.ungs.networks.CommunicationNetworksModuleInfrastructureTestCase;
import ar.edu.ungs.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


final class InMemoryCommunicationNetworkRepositoryShould extends CommunicationNetworksModuleInfrastructureTestCase {
	private InMemoryCommunicationNetworkRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = new InMemoryCommunicationNetworkRepository();
	}

	@Test
	void save_a_communication_network() {
		CommunicationNetwork aggregate = CommunicationNetworkMother.random();

		repository.save(aggregate);
	}

	@Test
	void return_an_existing_communication_network() {
		CommunicationNetwork aggregate = CommunicationNetworkMother.random();

		repository.save(aggregate);

		assertTrue(repository.find().isPresent());
	}

	@Test
	void not_return_a_non_existing_communication_network() {
		assertTrue(repository.find().isEmpty());
	}
}