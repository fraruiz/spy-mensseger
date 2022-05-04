package ar.edu.ungs.spymensseger.modules.communications.application;

import ar.edu.ungs.spymensseger.modules.spies.application.SpyRequest;

import java.util.Objects;

public final class CommunicationRequest {
	private final SpyRequest spy;
	private final Double probability;

	public CommunicationRequest(SpyRequest spy, Double probability) {
		this.spy = spy;
		this.probability = probability;
	}

	public SpyRequest spy() {
		return spy;
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
		return Objects.equals(spy, that.spy) && Objects.equals(probability, that.probability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(spy, probability);
	}

	@Override
	public String toString() {
		return "CommunicationRequest{" + "spy=" + spy + ", probability=" + probability + '}';
	}
}
