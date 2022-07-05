package ar.edu.ungs.networks.domain.mst;

import ar.edu.ungs.networks.domain.mst.prim.PrimMinimumCommunicationNetworkSpanningSolver;
import ar.edu.ungs.networks.domain.mst.kruskal.KruskalMinimumCommunicationNetworkSpanningSolver;

import java.util.HashMap;
import java.util.Map;

public final class MinimumCommunicationNetworkSpanningSolverStrategy {
    private final Map<MinimumCommunicationNetworkSpanningStrategy, MinimumCommunicationNetworkSpanningSolver> strategies;

    public MinimumCommunicationNetworkSpanningSolverStrategy() {
        this.strategies = new HashMap<>();

        this.strategies.put(MinimumCommunicationNetworkSpanningStrategy.PRIM, new PrimMinimumCommunicationNetworkSpanningSolver());
        this.strategies.put(MinimumCommunicationNetworkSpanningStrategy.KRUSKAL, new KruskalMinimumCommunicationNetworkSpanningSolver());
    }

    public MinimumCommunicationNetworkSpanningSolver solver(MinimumCommunicationNetworkSpanningStrategy strategy) {
        return strategies.get(strategy);
    }
}
