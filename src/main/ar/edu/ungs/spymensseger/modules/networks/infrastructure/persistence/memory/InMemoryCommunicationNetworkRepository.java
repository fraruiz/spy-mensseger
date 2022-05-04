package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.memory;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;

import java.util.Optional;

public final class InMemoryCommunicationNetworkRepository implements CommunicationNetworkRepository {
	@Override
	public void save(CommunicationNetwork network) {

	}

	@Override
	public Optional<CommunicationNetwork> find() {
		return Optional.empty();
	}
}
