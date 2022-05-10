package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto.FileCommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.shared.persistence.file.FileRepository;
import com.google.gson.JsonArray;

import java.util.Optional;

public final class FileCommunicationNetworkRepository extends FileRepository implements CommunicationNetworkRepository {
	public FileCommunicationNetworkRepository() {
		super("network.json");
	}

	@Override
	public void save(CommunicationNetwork network) {
		FileCommunicationNetwork dto = FileCommunicationNetwork.map(network);
		JsonArray jsonObject = FileCommunicationNetwork.toJson(dto);
		write(jsonObject);
	}

	@Override
	public Optional<CommunicationNetwork> find() {
		try {
			JsonArray jsonArray = read();
			FileCommunicationNetwork dto = FileCommunicationNetwork.fromJson(jsonArray);

			return Optional.ofNullable(FileCommunicationNetwork.map(dto));
		} catch (Exception error) {
			return Optional.empty();
		}
	}
}
