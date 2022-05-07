package ar.edu.ungs.spymensseger.modules.networks.domain.find;

import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleUnitTestCase;
import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkResponse;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkNotExists;
import ar.edu.ungs.spymensseger.modules.networks.domain.find.CommunicationNetworkFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CommunicationNetworkFinderShould extends CommunicationNetworksModuleUnitTestCase {
	private CommunicationNetworkFinder finder;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();

		this.finder = new CommunicationNetworkFinder(super.repository);
	}

	@Test
	void find_a_communication_network() {
		CommunicationNetwork expected = CommunicationNetworkMother.random();

		shouldFind(expected);

		CommunicationNetwork actual = this.finder.find();

		assertEquals(expected, actual);
	}

	@Test
	void throws_communication_network_not_exists_when_can_not_find() {
		assertThrows(CommunicationNetworkNotExists.class, () -> this.finder.find());
	}
}