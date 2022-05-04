package ar.edu.ungs.spymensseger.modules.networks.application.find;

import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkResponse;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkNotExists;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;

public final class CommunicationNetworkFinder {
	private final CommunicationNetworkRepository repository;

	public CommunicationNetworkFinder(CommunicationNetworkRepository repository) {
		this.repository = repository;
	}

	public CommunicationNetworkResponse find() {
		return repository.find()
		                 .map(CommunicationNetworkResponse::map)
		                 .orElseThrow(CommunicationNetworkNotExists::new);
	}
}
