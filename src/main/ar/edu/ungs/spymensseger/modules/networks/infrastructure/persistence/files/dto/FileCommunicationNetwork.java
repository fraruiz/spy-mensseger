package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	public static JSONArray toJson(FileCommunicationNetwork dto) {
		JSONArray jsonArray = new JSONArray();

		for (FileSpy fileSpy : dto.communications().keySet()) {
			JSONObject fileSpyJsonObject = new JSONObject();
			JSONArray communicationsJsonArray = new JSONArray();

			for (FileCommunication fileCommunication : dto.communications().get(fileSpy)) {
				communicationsJsonArray.add(FileCommunication.toJson(fileCommunication));
			}

			fileSpyJsonObject.put("spy", FileSpy.toJson(fileSpy));
			fileSpyJsonObject.put("communications", communicationsJsonArray);

			jsonArray.add(fileSpyJsonObject);
		}

		return jsonArray;
	}

	public static FileCommunicationNetwork fromJson(JSONArray jsonArray) {
		FileCommunicationNetwork dto = new FileCommunicationNetwork();
		for (Object o : jsonArray) {
			JSONObject jsonObject = (JSONObject) o;
			FileSpy fileSpy = FileSpy.fromJson((JSONObject) jsonObject.get("spy"));
			List<FileCommunication> fileCommunications = new ArrayList<>();
			for (Object communication : ((JSONArray) jsonObject.get("communications"))){
				fileCommunications.add(FileCommunication.fromJson((JSONObject) communication));
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
