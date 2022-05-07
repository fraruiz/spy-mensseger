package ar.edu.ungs.spymensseger.modules.networks.application.save;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationRequest;
import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkRequest;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.*;

public final class CommunicationNetworkSaver {
	private final CommunicationNetworkRepository repository;
	public CommunicationNetworkSaver(CommunicationNetworkRepository repository) {
		this.repository = repository;
	}

	public void save(CommunicationNetworkRequest request) {
		Map<String, Spy> spies = mapSpies(request);
		CommunicationNetwork network = new CommunicationNetwork(spies.size());


	}

	private Map<String, Spy> mapSpies(CommunicationNetworkRequest request) {
		Map<String, Spy> spies = new HashMap<>();

		Integer id = 0;
		for (CommunicationRequest communicationRequest : request.network()) {
			if (!spies.containsKey(communicationRequest.firstSpy())) {
				String name = communicationRequest.firstSpy();
				spies.put(name, new Spy(id, name));
			}

			if (!spies.containsKey(communicationRequest.secondSpy())) {
				String name = communicationRequest.secondSpy();
				spies.put(name, new Spy(id, name));
			}
		}

		return spies;
	}
}
