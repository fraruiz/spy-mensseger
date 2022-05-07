package ar.edu.ungs.spymensseger.modules.networks.domain.mst;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;

public interface MinimumCommunicationNetworkSpanningSolver {
	CommunicationNetwork solve(CommunicationNetwork network);
}
