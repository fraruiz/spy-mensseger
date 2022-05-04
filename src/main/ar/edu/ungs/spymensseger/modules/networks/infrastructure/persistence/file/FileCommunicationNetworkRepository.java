package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.file;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.file.FileRepository;

import java.util.Optional;

public final class FileCommunicationNetworkRepository extends FileRepository implements CommunicationNetworkRepository {
	@Override
	public void save(CommunicationNetwork network) {

	}

	@Override
	public Optional<CommunicationNetwork> find() {
		return Optional.empty();
	}
}
