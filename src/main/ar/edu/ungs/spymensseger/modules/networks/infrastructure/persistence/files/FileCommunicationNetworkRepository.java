package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto.FileCommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.shared.persistence.file.FileRepository;
import org.json.simple.JSONArray;

import java.util.Optional;

public final class FileCommunicationNetworkRepository extends FileRepository implements CommunicationNetworkRepository {
	public FileCommunicationNetworkRepository() {
		super("src/main/resources/network.json");
	}

	@Override
	public void save(CommunicationNetwork network) {
		FileCommunicationNetwork dto = FileCommunicationNetwork.map(network);
		JSONArray jsonObject = FileCommunicationNetwork.toJson(dto);
		write(jsonObject);
	}

	@Override
	public Optional<CommunicationNetwork> find() {
		try {
			JSONArray jsonArray = read();
			FileCommunicationNetwork dto = FileCommunicationNetwork.fromJson(jsonArray);

			return Optional.ofNullable(FileCommunicationNetwork.map(dto));
		} catch (Exception error) {
			return Optional.empty();
		}
	}
}
