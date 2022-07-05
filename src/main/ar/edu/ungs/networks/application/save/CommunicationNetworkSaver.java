package ar.edu.ungs.networks.application.save;

import ar.edu.ungs.networks.application.CommunicationNetworkRequest;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.CommunicationNetworkRepository;

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
