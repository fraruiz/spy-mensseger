package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.GraphRepository;

import java.util.Optional;

public final class GraphCommunicationNetworkRepository extends GraphRepository implements CommunicationNetworkRepository {
	@Override
	public void save(CommunicationNetwork network) {

	}

	@Override
	public Optional<CommunicationNetwork> find() {
		return Optional.empty();
	}
}
