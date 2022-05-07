package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import org.json.simple.JSONObject;

import java.util.Objects;

public final class FileCommunication {
	private final FileSpy firstSpy;
	private final FileSpy secondSpy;
	private final Double probability;

	public FileCommunication(FileSpy firstSpy, FileSpy secondSpy, Double probability) {
		this.firstSpy = firstSpy;
		this.secondSpy = secondSpy;
		this.probability = probability;
	}

	public static FileCommunication map(Communication aggregate){
		return new FileCommunication(FileSpy.map(aggregate.firstSpy()),
		                             FileSpy.map(aggregate.secondSpy()),
		                             aggregate.probability().value());
	}

	public static Communication map(FileCommunication dto) {
		return new Communication(FileSpy.map(dto.firstSpy()),
		                         FileSpy.map(dto.secondSpy()),
		                         new Probability(dto.probability()));
	}

	public static JSONObject toJson(FileCommunication dto){
		return new JSONObject() {{
			put("firstSpy", FileSpy.toJson(dto.firstSpy()));
			put("secondSpy", FileSpy.toJson(dto.secondSpy()));
			put("probability", dto.probability());
		}};
	}

	public static FileCommunication fromJson(JSONObject jsonObject) {
		FileSpy firstSpy = FileSpy.fromJson((JSONObject) jsonObject.get("firstSpy"));
		FileSpy secondSpy = FileSpy.fromJson((JSONObject) jsonObject.get("secondSpy"));
		Double probability = (Double) jsonObject.get("probability");

		return new FileCommunication(firstSpy, secondSpy, probability);
	}

	public FileSpy firstSpy() {
		return firstSpy;
	}

	public FileSpy secondSpy() {
		return secondSpy;
	}

	public Double probability() {
		return probability;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FileCommunication that = (FileCommunication) o;
		return Objects.equals(firstSpy, that.firstSpy) && Objects.equals(secondSpy, that.secondSpy) &&
		       Objects.equals(probability, that.probability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstSpy, secondSpy, probability);
	}

	@Override
	public String toString() {
		return "FileCommunication{" + "firstSpy=" + firstSpy + ", secondSpy=" + secondSpy + ", probability=" +
		       probability + '}';
	}
}
