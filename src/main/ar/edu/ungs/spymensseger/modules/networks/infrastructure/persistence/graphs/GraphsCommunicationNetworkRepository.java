package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.FileGraphRepository;

import java.util.Optional;

public final class GraphsCommunicationNetworkRepository extends FileGraphRepository implements CommunicationNetworkRepository {
	@Override
	public void save(CommunicationNetwork network) {

	}

	@Override
	public Optional<CommunicationNetwork> find() {
		return Optional.empty();
	}
}
