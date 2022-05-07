package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.inmemory;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.file.FileRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
