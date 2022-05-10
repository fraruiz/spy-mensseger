package ar.edu.ungs.spymensseger.modules.communications.domain;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;

import java.util.List;

public final class CommunicationMother {
	public static Communication build(Spy firstSpy, Spy secondSpy, Probability probability) {
		return new Communication(firstSpy, secondSpy, probability);
	}
}
