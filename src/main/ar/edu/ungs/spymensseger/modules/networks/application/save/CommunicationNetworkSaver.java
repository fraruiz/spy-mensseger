package ar.edu.ungs.spymensseger.modules.networks.application.save;

import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkRequest;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;

public final class CommunicationNetworkSaver {
	private final CommunicationNetworkRepository repository;
	public CommunicationNetworkSaver(CommunicationNetworkRepository repository) {
		this.repository = repository;
	}

	public void save(CommunicationNetworkRequest request) {
		CommunicationNetwork network = CommunicationNetworkRequest.map(request);

		repository.save(network);
	}
}
