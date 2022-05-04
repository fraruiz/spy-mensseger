package ar.edu.ungs.spymensseger.modules.networks.domain;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.CommunicationMother;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;

import java.util.List;

public final class CommunicationNetworkMother {
	public static CommunicationNetwork random() {
		return build(CommunicationMother.randoms(SpyMother.random()));
	}

	private static CommunicationNetwork build(List<Communication> communications) {
		return new CommunicationNetwork(communications);
	}
}
