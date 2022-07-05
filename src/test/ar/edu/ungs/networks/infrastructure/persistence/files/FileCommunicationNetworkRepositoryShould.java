package ar.edu.ungs.networks.infrastructure.persistence.files;

import ar.edu.ungs.networks.CommunicationNetworksModuleInfrastructureTestCase;
import ar.edu.ungs.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class FileCommunicationNetworkRepositoryShould extends CommunicationNetworksModuleInfrastructureTestCase {
	private FileCommunicationNetworkRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = new FileCommunicationNetworkRepository();
	}

	@AfterAll
	static void afterAll() {
		new FileCommunicationNetworkRepository().save(CommunicationNetworkMother.preset());
	}

	@BeforeAll
	static void beforeAll() {
		new FileCommunicationNetworkRepository().clean();
	}

	@Test
	void save_a_communication_network() {
		CommunicationNetwork aggregate = CommunicationNetworkMother.random();

		repository.save(aggregate);
	}

	@Test
	void return_an_existing_communication_network() {
		CommunicationNetwork aggregate = CommunicationNetworkMother.random();

		repository.clean();
		repository.save(aggregate);

		assertTrue(repository.find().isPresent());
	}

	@Test
	void not_return_a_non_existing_communication_network() {
		repository.clean();
		assertTrue(repository.find().isEmpty());
	}
}