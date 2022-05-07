package ar.edu.ungs.spymensseger.modules.networks.domain;

import ar.edu.ungs.spymensseger.modules.communications.domain.ProbabilityMother;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;

public final class CommunicationNetworkMother {
	public static CommunicationNetwork undirectedRandom() {
		CommunicationNetwork network = new CommunicationNetwork(10);

		network.add(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.8D));

		network.add(SpyMother.random(1),SpyMother.random(4), ProbabilityMother.build(0.4D));

		network.add(SpyMother.random(2),SpyMother.random(3), ProbabilityMother.build(0.5D));

		network.add(SpyMother.random(3),SpyMother.random(2), ProbabilityMother.build(0.5D));
		network.add(SpyMother.random(3),SpyMother.random(4), ProbabilityMother.build(0.7D));
		network.add(SpyMother.random(3),SpyMother.random(6), ProbabilityMother.build(0.11D));

		network.add(SpyMother.random(4),SpyMother.random(5), ProbabilityMother.build(0.2D));
		network.add(SpyMother.random(4),SpyMother.random(3), ProbabilityMother.build(0.7D));

		network.add(SpyMother.random(5),SpyMother.random(7), ProbabilityMother.build(0.14D));
		network.add(SpyMother.random(5),SpyMother.random(8), ProbabilityMother.build(0.6D));

		network.add(SpyMother.random(7),SpyMother.random(5), ProbabilityMother.build(0.14D));

		network.add(SpyMother.random(8),SpyMother.random(5), ProbabilityMother.build(0.6D));
		network.add(SpyMother.random(8),SpyMother.random(9), ProbabilityMother.build(0.3D));

		network.add(SpyMother.random(9),SpyMother.random(8), ProbabilityMother.build(0.3D));

		return network;
	}

	public static CommunicationNetwork minimumRandom() {
		CommunicationNetwork network = new CommunicationNetwork(10);

		network.add(SpyMother.random(0),SpyMother.random(1), ProbabilityMother.build(0.8D));

		network.add(SpyMother.random(1),SpyMother.random(4), ProbabilityMother.build(0.4D));
		network.add(SpyMother.random(1),SpyMother.random(2), ProbabilityMother.build(0.10D));

		network.add(SpyMother.random(2),SpyMother.random(1), ProbabilityMother.build(0.10D));
		network.add(SpyMother.random(2),SpyMother.random(3), ProbabilityMother.build(0.5D));

		network.add(SpyMother.random(3),SpyMother.random(2), ProbabilityMother.build(0.5D));
		network.add(SpyMother.random(3),SpyMother.random(4), ProbabilityMother.build(0.7D));
		network.add(SpyMother.random(3),SpyMother.random(6), ProbabilityMother.build(0.11D));

		network.add(SpyMother.random(4),SpyMother.random(5), ProbabilityMother.build(0.2D));
		network.add(SpyMother.random(4),SpyMother.random(3), ProbabilityMother.build(0.7D));

		network.add(SpyMother.random(5),SpyMother.random(6), ProbabilityMother.build(0.12D));
		network.add(SpyMother.random(5),SpyMother.random(7), ProbabilityMother.build(0.14D));
		network.add(SpyMother.random(5),SpyMother.random(8), ProbabilityMother.build(0.6D));
		network.add(SpyMother.random(5),SpyMother.random(9), ProbabilityMother.build(0.9D));

		network.add(SpyMother.random(6),SpyMother.random(5), ProbabilityMother.build(0.12D));
		network.add(SpyMother.random(6),SpyMother.random(7), ProbabilityMother.build(0.20D));

		network.add(SpyMother.random(7),SpyMother.random(5), ProbabilityMother.build(0.14D));
		network.add(SpyMother.random(7),SpyMother.random(6), ProbabilityMother.build(0.20D));

		network.add(SpyMother.random(8),SpyMother.random(5), ProbabilityMother.build(0.6D));
		network.add(SpyMother.random(8),SpyMother.random(7), ProbabilityMother.build(0.17D));
		network.add(SpyMother.random(8),SpyMother.random(9), ProbabilityMother.build(0.3D));

		network.add(SpyMother.random(9),SpyMother.random(5), ProbabilityMother.build(0.9D));
		network.add(SpyMother.random(9),SpyMother.random(8), ProbabilityMother.build(0.3D));

		return network;
	}
}
