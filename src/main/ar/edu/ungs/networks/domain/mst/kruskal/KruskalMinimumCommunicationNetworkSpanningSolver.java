package ar.edu.ungs.networks.domain.mst.kruskal;

import ar.edu.ungs.communications.domain.Communication;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.mst.MinimumCommunicationNetworkSpanningSolver;
import ar.edu.ungs.networks.domain.mst.unionfind.UnionFindSolver;

import java.util.List;
import java.util.stream.Collectors;

public final class KruskalMinimumCommunicationNetworkSpanningSolver implements MinimumCommunicationNetworkSpanningSolver {
	@Override
	public CommunicationNetwork solve(CommunicationNetwork network) {
		List<Communication> communications = network.communications().stream()
		                                            .sorted(Communication::compareProbability)
		                                            .collect(Collectors.toList());
		int totalSpies = network.size();
		UnionFindSolver unionFindSolver = new UnionFindSolver(totalSpies);
		int communicationCount = 0;

		CommunicationNetwork minimumSpanningCommunicationNetwork = new CommunicationNetwork(totalSpies);

		for (Communication communication: communications) {
			if (unionFindSolver.detectCycle(communication)) {
				continue;
			}

			minimumSpanningCommunicationNetwork.add(communication.firstSpy(), communication.secondSpy(), communication.probability());
			communicationCount++;

			if (communicationCount == totalSpies - 1) {
				break;
			}
		}

		return minimumSpanningCommunicationNetwork;
	}
}
