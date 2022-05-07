package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleInfrastructureTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class FileCommunicationNetworkRepositoryShould extends CommunicationNetworksModuleInfrastructureTestCase {
	private FileCommunicationNetworkRepository graphRepository;

	@BeforeEach
	void setUp() {
		this.graphRepository = new FileCommunicationNetworkRepository();
	}

	@Test
	void save_a_communication_network() {
	}

	@Test
	void return_an_existing_communication_network() {
	}

	@Test
	void not_return_a_non_existing_communication_network() {
	}
}