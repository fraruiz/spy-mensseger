package ar.edu.ungs.spymensseger.modules.networks.application.save;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationRequest;
import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.spies.application.SpyRequest;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.ArrayList;
import java.util.List;

public final class CommunicationNetworkSaver {
	private final CommunicationNetworkRepository repository;
	public CommunicationNetworkSaver(CommunicationNetworkRepository repository) {
		this.repository = repository;
	}

	public void save(SpyRequest spyRequest, List<CommunicationRequest> communicationsRequest) {
		List<Communication> communications = new ArrayList<>();

		communicationsRequest.forEach(communicationRequest -> {
			Spy firstSpy = new Spy(spyRequest.name());
			Spy secondSpy = new Spy(communicationRequest.spy().name());
			Probability probability = new Probability(communicationRequest.probability());

			Communication communication = new Communication(firstSpy, secondSpy, probability);

			communications.add(communication);
		});

		CommunicationNetwork network = new CommunicationNetwork(communications);

		repository.save(network);
	}
}
