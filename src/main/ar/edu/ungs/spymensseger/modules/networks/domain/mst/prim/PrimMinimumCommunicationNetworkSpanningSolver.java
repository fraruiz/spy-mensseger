package ar.edu.ungs.spymensseger.modules.networks.domain.mst.prim;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.mst.MinimumCommunicationNetworkSpanningSolver;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class PrimMinimumCommunicationNetworkSpanningSolver implements MinimumCommunicationNetworkSpanningSolver {
	private Set<Spy> spies;
	private Set<Communication> communications;

	public PrimMinimumCommunicationNetworkSpanningSolver() {
		this.spies = new HashSet<Spy>();
		this.communications = new HashSet<Communication>();
	}

	@Override
	public CommunicationNetwork solve(CommunicationNetwork network) {
		spies.add(network.firstSpy());
		int counter = 1;

		while (counter < network.size()) {
			Communication communication = findMinimumCommunication(network);

			communications.add(communication);
			spies.add(communication.secondSpy());
			counter++;
		}

		CommunicationNetwork result = buildCommunicationNetwork();
		this.cleanAttributes();
		return result;
	}

	private CommunicationNetwork buildCommunicationNetwork() {
		CommunicationNetwork result = new CommunicationNetwork(this.spies.size());
		communications.forEach(communication -> result.add(communication.firstSpy(),
		                                                   communication.secondSpy(),
		                                                   communication.probability()));
		return result;
	}

	private void cleanAttributes() {
		this.spies = new HashSet<>();
		this.communications = new HashSet<>();
	}

	private Communication findMinimumCommunication(CommunicationNetwork network) {
		return searchCommunicationsWhereOnlyOneVisitedSpy(network)
				.stream()
				.min(Communication::compareTo)
				.orElseThrow(() -> new IllegalArgumentException("can not find a minimum edge"));
	}

	private Set<Communication> searchCommunicationsWhereOnlyOneVisitedSpy(CommunicationNetwork network) {
		Set<Communication> communicationsWhereOnlyOneVisitedSpy = new HashSet<>();

		for (Spy spy : this.spies) {
			Set<Spy> neighbours = network.neighbours(spy);

			for (Spy neighbour : neighbours) {
				Optional<Probability> probability = network.probability(spy, neighbour);

				if (probability.isPresent() && isOnlyOneVisitedSpy(spy, neighbour)) {
					Communication communication = new Communication(spy, neighbour, probability.get());
					communicationsWhereOnlyOneVisitedSpy.add(communication);
				}
			}
		}

		return communicationsWhereOnlyOneVisitedSpy;
	}

	private boolean isOnlyOneVisitedSpy(Spy spy, Spy neighbour) {
		return (this.spies.contains(spy) && !this.spies.contains(neighbour)) ||
		       (this.spies.contains(neighbour) && !this.spies.contains(spy));
	}
}
