package ar.edu.ungs.spymensseger.modules.communications.application;

import java.util.Objects;

public final class CommunicationRequest {
	private final String firstSpy;
	private final String secondSpy;
	private final Double probability;

	public CommunicationRequest(String firstSpy, String secondSpy, Double probability) {
		this.firstSpy = firstSpy;
		this.secondSpy = secondSpy;
		this.probability = probability;
	}

	public String firstSpy() {
		return firstSpy;
	}

	public String secondSpy() {
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
		CommunicationRequest that = (CommunicationRequest) o;
		return Objects.equals(firstSpy, that.firstSpy) && Objects.equals(secondSpy, that.secondSpy) &&
		       Objects.equals(probability, that.probability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstSpy, secondSpy, probability);
	}

	@Override
	public String toString() {
		return "CommunicationRequest{" + "firstSpy=" + firstSpy + ", secondSpy=" + secondSpy + ", probability=" +
		       probability + '}';
	}
}
