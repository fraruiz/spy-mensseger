package ar.edu.ungs.spymensseger.modules.networks.application.save;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleUnitTestCase;
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
	}

	@Test
	void throws_invalid_probability_when_one_or_more_probabilities_are_not_valid() {
	}
}