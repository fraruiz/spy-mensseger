package ar.edu.ungs.networks.application.mst;

import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.find.CommunicationNetworkFinder;
import ar.edu.ungs.networks.domain.mst.MinimumCommunicationNetworkSpanningSolver;
import ar.edu.ungs.networks.application.CommunicationNetworkResponse;

public final class MinimumCommunicationNetworkSpanningSearcher {
	private final CommunicationNetworkFinder finder;
	private final MinimumCommunicationNetworkSpanningSolver solver;

	public MinimumCommunicationNetworkSpanningSearcher(CommunicationNetworkFinder finder,
	                                                   MinimumCommunicationNetworkSpanningSolver solver) {
		this.finder = finder;
		this.solver = solver;
	}

	public CommunicationNetworkResponse search() {
		CommunicationNetwork network = finder.find();

		CommunicationNetwork minimumCommunicationNetworkSpanning = solver.solve(network);

		return CommunicationNetworkResponse.map(minimumCommunicationNetworkSpanning);
	}
}
