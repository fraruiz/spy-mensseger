package ar.edu.ungs.networks.infrastructure.persistence.inmemory;

import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.CommunicationNetworkRepository;

import java.util.Optional;

public final class InMemoryCommunicationNetworkRepository implements CommunicationNetworkRepository {
	private Optional<CommunicationNetwork> communicationNetwork;

	public InMemoryCommunicationNetworkRepository() {
		this.communicationNetwork = Optional.empty();
	}

	@Override
	public void save(CommunicationNetwork network) {
		this.communicationNetwork = Optional.ofNullable(network);
	}

	@Override
	public Optional<CommunicationNetwork> find() {
		return communicationNetwork;
	}
}
