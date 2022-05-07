package ar.edu.ungs.spymensseger.modules.communications.domain;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.Objects;

public final class Communication implements Comparable<Communication>{
	private final Spy firstSpy;
	private final Spy secondSpy;
	private final Probability probability;

	public Communication(Spy firstSpy, Spy secondSpy, Probability probability) {
		this.firstSpy = firstSpy;
		this.secondSpy = secondSpy;
		this.probability = probability;
	}

	public Spy firstSpy() {
		return firstSpy;
	}

	public Spy secondSpy() {
		return secondSpy;
	}

	public Probability probability() {
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
		Communication that = (Communication) o;

		boolean a = Objects.equals(firstSpy.id(), that.firstSpy.id()) && Objects.equals(secondSpy.id(), that.secondSpy.id());
		boolean b = Objects.equals(firstSpy.id(), that.secondSpy.id()) && Objects.equals(secondSpy.id(), that.firstSpy.id());
		boolean w = Objects.equals(probability, that.probability);

		return (a || b) && w;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstSpy, secondSpy, probability);
	}

	@Override
	public String toString() {
		return "Communication{" + "firstSpy=" + firstSpy + ", secondSpy=" + secondSpy + ", probability=" + probability +
		       '}';
	}

	@Override
	public int compareTo(Communication o) {
		return this.probability.compareTo(o.probability());
	}
}
