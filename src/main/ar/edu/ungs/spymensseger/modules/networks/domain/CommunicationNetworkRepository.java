package ar.edu.ungs.spymensseger.modules.networks.domain;

import java.util.Optional;

public interface CommunicationNetworkRepository {
	void save(CommunicationNetwork network);

	Optional<CommunicationNetwork> find();
}
