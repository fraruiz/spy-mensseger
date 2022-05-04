package ar.edu.ungs.spymensseger.modules.networks.application.create;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationRequest;
import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.InvalidProbability;
import ar.edu.ungs.spymensseger.modules.networks.CommunicationNetworksModuleUnitTestCase;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkMother;
import ar.edu.ungs.spymensseger.modules.spies.application.SpyRequest;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class CommunicationNetworkSaverShould extends CommunicationNetworksModuleUnitTestCase {
	private CommunicationNetworkSaver saver;

	@BeforeEach
	public void setUp() {
		super.setUp();

		this.saver = new CommunicationNetworkSaver(repository);
	}

	@Test
	void crete_a_valid_network() {
		CommunicationNetwork expected = CommunicationNetworkMother.random();

		SpyRequest spyRequest = buildSpyRequest(expected.communications().get(0).firstSpy());
		List<CommunicationRequest> communicationsRequest = buildCommunicationRequest(expected.communications());

		saver.save(spyRequest, communicationsRequest);

		shouldSaved(expected);
	}

	@Test
	void throws_invalid_probability_when_one_or_more_probabilities_are_not_valid() {
		CommunicationNetwork expected = CommunicationNetworkMother.random();

		SpyRequest spyRequest = buildSpyRequest(expected.communications().get(0).firstSpy());
		List<CommunicationRequest> communicationsRequest = buildInvalidCommunicationRequest(expected.communications());

		assertThrows(InvalidProbability.class, () -> saver.save(spyRequest, communicationsRequest));
	}

	private List<CommunicationRequest> buildCommunicationRequest(List<Communication> communicationsExpected) {
		return communicationsExpected.stream()
		                             .map(communication -> new CommunicationRequest(
				                             new SpyRequest(communication.secondSpy().name()),
				                             communication.probability().value()))
		                             .collect(Collectors.toList());
	}

	private List<CommunicationRequest> buildInvalidCommunicationRequest(List<Communication> communicationsExpected) {
		return communicationsExpected.stream()
		                             .map(communication -> new CommunicationRequest(
				                             new SpyRequest(communication.secondSpy().name()), -100D))
		                             .collect(Collectors.toList());
	}

	private SpyRequest buildSpyRequest(Spy firstSpyExpected) {
		return new SpyRequest(firstSpyExpected.name());
	}
}