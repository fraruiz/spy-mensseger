package ar.edu.ungs.networks.domain.find;

import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.CommunicationNetworkNotExists;
import ar.edu.ungs.networks.domain.CommunicationNetworkRepository;

public final class CommunicationNetworkFinder {
	private final CommunicationNetworkRepository repository;

	public CommunicationNetworkFinder(CommunicationNetworkRepository repository) {
		this.repository = repository;
	}

	public CommunicationNetwork find() {
		return repository.find().orElseThrow(CommunicationNetworkNotExists::new);
	}
}
