package ar.edu.ungs.networks.infrastructure.persistence.files.dto;

import ar.edu.ungs.communications.domain.Communication;
import ar.edu.ungs.communications.domain.Probability;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spies.domain.Spy;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.*;

public final class FileCommunicationNetwork {
	private final Map<FileSpy, List<FileCommunication>> communications;

	public FileCommunicationNetwork() {
		this.communications = new HashMap<>();
	}

	public static FileCommunicationNetwork map(CommunicationNetwork aggregate) {
		FileCommunicationNetwork dto = new FileCommunicationNetwork();
		Set<Spy> aggregateSpies = aggregate.spies();

		for (Spy spy : aggregateSpies) {
			List<FileCommunication> communications = new ArrayList<>();
			Set<Spy> neighbours = aggregate.neighbours(spy);

			for (Spy neighbour : neighbours) {
				Optional<Probability> probability = aggregate.probability(spy, neighbour);

				probability.ifPresent(value -> communications.add(new FileCommunication(FileSpy.map(spy), FileSpy.map(neighbour), value.value())));
			}

			dto.add(FileSpy.map(spy), communications);
		}

		return dto;
	}

	public static CommunicationNetwork map(FileCommunicationNetwork dto) {
		CommunicationNetwork communicationNetwork = new CommunicationNetwork(dto.communications().size());

		for (FileSpy fileSpy : dto.communications().keySet()) {
			for (FileCommunication fileCommunication : dto.communications().get(fileSpy)) {
				Communication communication = FileCommunication.map(fileCommunication);

				communicationNetwork.add(communication.firstSpy(), communication.secondSpy(), communication.probability());
			}
		}

		return communicationNetwork;
	}

	public static JsonArray toJson(FileCommunicationNetwork dto) {
		JsonArray jsonArray = new JsonArray();

		for (FileSpy fileSpy : dto.communications().keySet()) {
			JsonObject fileSpyJsonObject = new JsonObject();
			JsonArray communicationsJsonArray = new JsonArray();

			for (FileCommunication fileCommunication : dto.communications().get(fileSpy)) {
				communicationsJsonArray.add(FileCommunication.toJson(fileCommunication));
			}

			fileSpyJsonObject.add("spy", FileSpy.toJson(fileSpy));
			fileSpyJsonObject.add("communications", communicationsJsonArray);

			jsonArray.add(fileSpyJsonObject);
		}

		return jsonArray;
	}

	public static FileCommunicationNetwork fromJson(JsonArray jsonArray) {
		FileCommunicationNetwork dto = new FileCommunicationNetwork();
		for (Object o : jsonArray) {
			JsonObject jsonObject = (JsonObject) o;
			FileSpy fileSpy = FileSpy.fromJson((JsonObject) jsonObject.get("spy"));
			List<FileCommunication> fileCommunications = new ArrayList<>();
			for (Object communication : ((JsonArray) jsonObject.get("communications"))){
				fileCommunications.add(FileCommunication.fromJson((JsonObject) communication));
			}

			dto.add(fileSpy, fileCommunications);
		}

		return dto;
	}

	public void add(FileSpy spy, List<FileCommunication> communications) {
		this.communications.put(spy, communications);
	}

	public Map<FileSpy, List<FileCommunication>> communications() {
		return communications;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FileCommunicationNetwork that = (FileCommunicationNetwork) o;
		return Objects.equals(communications, that.communications);
	}

	@Override
	public String toString() {
		return "FileCommunicationNetwork{" + "communications=" + communications + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(communications);
	}
}
