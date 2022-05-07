package ar.edu.ungs.spymensseger.modules.networks.application;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationRequest;

import java.util.HashSet;
import java.util.Set;

public final class CommunicationNetworkRequestMother {
	public static CommunicationNetworkRequest random() {
		Set<CommunicationRequest> network = new HashSet<>(){{
			add(new CommunicationRequest("spy 0", "spy 1", 0.8D));
			add(new CommunicationRequest("spy 1", "spy 2", 0.4D));
			add(new CommunicationRequest("spy 2", "spy 0", 0.5D));
		}};

		return new CommunicationNetworkRequest(network);
	}
}
