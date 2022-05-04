package ar.edu.ungs.spymensseger.modules.communications.domain;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;

import java.util.List;

public final class CommunicationMother {

	public static List<Communication> randoms(Spy firstSpy) {
		return List.of(random(firstSpy), random(firstSpy), random(firstSpy), random(firstSpy), random(firstSpy));
	}
	public static List<Communication> randoms() {
		return List.of(random(), random(), random(), random(), random());
	}

	public static Communication random(Spy firstSpy) {
		return build(firstSpy, SpyMother.random(), ProbabilityMother.random());
	}

	public static Communication random() {
		return build(SpyMother.random(), SpyMother.random(), ProbabilityMother.random());
	}

	private static Communication build(Spy firstSpy, Spy secondSpy, Probability probability) {
		return new Communication(firstSpy, secondSpy, probability);
	}
}
