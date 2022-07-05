package ar.edu.ungs.networks.domain.mst;

import ar.edu.ungs.networks.domain.CommunicationNetwork;

public interface MinimumCommunicationNetworkSpanningSolver {
	CommunicationNetwork solve(CommunicationNetwork network);
}
