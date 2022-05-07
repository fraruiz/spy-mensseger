package ar.edu.ungs.spymensseger.modules.networks.domain;

import ar.edu.ungs.spymensseger.modules.communications.domain.ProbabilityMother;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;

public final class CommunicationNetworkMother {
	public static CommunicationNetwork undirectedRandom() {
		CommunicationNetwork network = new CommunicationNetwork(4);

		network.add(SpyMother.build(0, "spy 0"), SpyMother.build(1, "spy 1"), ProbabilityMother.build(0.1D));
		network.add(SpyMother.build(0, "spy 0"), SpyMother.build(2, "spy 2"), ProbabilityMother.build(0.3D));
		network.add(SpyMother.build(1, "spy 1"), SpyMother.build(3, "spy 3"), ProbabilityMother.build(0.4D));
		network.add(SpyMother.build(3, "spy 3"), SpyMother.build(2, "spy 2"), ProbabilityMother.build(0.3D));

		return network;
	}

	public static CommunicationNetwork minimumRandom() {
		CommunicationNetwork network = new CommunicationNetwork(4);

		network.add(SpyMother.build(0, "spy 0"), SpyMother.build(1, "spy 1"), ProbabilityMother.build(0.1D));
		network.add(SpyMother.build(0, "spy 0"), SpyMother.build(2, "spy 2"), ProbabilityMother.build(0.3D));
		network.add(SpyMother.build(3, "spy 3"), SpyMother.build(2, "spy 2"), ProbabilityMother.build(0.3D));

		return network;
	}

	public static CommunicationNetwork random() {
		CommunicationNetwork network = new CommunicationNetwork(3);

		network.add(SpyMother.build(0, "spy 0"), SpyMother.build(1, "spy 1"), ProbabilityMother.build(0.8D));
		network.add(SpyMother.build(1, "spy 1"),SpyMother.build(2, "spy 2"), ProbabilityMother.build(0.4D));
		network.add(SpyMother.build(2, "spy 2"),SpyMother.build(0, "spy 0"), ProbabilityMother.build(0.5D));

		return network;
	}
}
