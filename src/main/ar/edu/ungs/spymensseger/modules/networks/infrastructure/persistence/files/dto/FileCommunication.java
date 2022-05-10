package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import com.google.gson.JsonObject;

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

	public static JsonObject toJson(FileCommunication dto){
		JsonObject o = new JsonObject();
		o.add("firstSpy", FileSpy.toJson(dto.firstSpy()));
		o.add("secondSpy", FileSpy.toJson(dto.secondSpy()));
		o.addProperty("probability", dto.probability());
		return o;
	}

	public static FileCommunication fromJson(JsonObject jsonObject) {
		FileSpy firstSpy = FileSpy.fromJson((JsonObject) jsonObject.get("firstSpy"));
		FileSpy secondSpy = FileSpy.fromJson((JsonObject) jsonObject.get("secondSpy"));
		Double probability = (Double) jsonObject.get("probability").getAsDouble();

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
