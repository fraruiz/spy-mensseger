package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.inmemory;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleInfrastructureTestCase;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
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