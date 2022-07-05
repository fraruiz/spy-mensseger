package ar.edu.ungs.networks.application.save;

import ar.edu.ungs.networks.CommunicationNetworksModuleUnitTestCase;
import ar.edu.ungs.networks.application.CommunicationNetworkRequestMother;
import ar.edu.ungs.networks.application.CommunicationNetworkRequest;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CommunicationNetworkSaverShould extends CommunicationNetworksModuleUnitTestCase {
	private CommunicationNetworkSaver saver;

	@BeforeEach
	public void setUp() {
		super.setUp();

		this.saver = new CommunicationNetworkSaver(repository);
	}

	@Test
	void crete_a_valid_network() {
		CommunicationNetworkRequest request = CommunicationNetworkRequestMother.random();
		CommunicationNetwork expected = CommunicationNetworkRequest.map(request);

		saver.save(request);

		shouldSaved(expected);
	}
}