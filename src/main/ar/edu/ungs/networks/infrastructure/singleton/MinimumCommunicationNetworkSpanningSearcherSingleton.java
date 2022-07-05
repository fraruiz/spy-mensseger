package ar.edu.ungs.networks.infrastructure.singleton;

import ar.edu.ungs.networks.application.mst.MinimumCommunicationNetworkSpanningSearcher;
import ar.edu.ungs.networks.domain.mst.MinimumCommunicationNetworkSpanningSolverStrategy;
import ar.edu.ungs.networks.domain.mst.MinimumCommunicationNetworkSpanningStrategy;
import ar.edu.ungs.persistence.PersistenceType;

public final class MinimumCommunicationNetworkSpanningSearcherSingleton {
    private static MinimumCommunicationNetworkSpanningSearcher instance;

    private MinimumCommunicationNetworkSpanningSearcherSingleton() {
    }

    public static MinimumCommunicationNetworkSpanningSearcher instance(PersistenceType persistenceType, MinimumCommunicationNetworkSpanningStrategy spanningStrategy) {
        MinimumCommunicationNetworkSpanningSearcher result = instance;
        if (result != null) {
            return result;
        }
        synchronized(MinimumCommunicationNetworkSpanningSearcher.class) {
            if (instance == null) {
                instance = new MinimumCommunicationNetworkSpanningSearcher(CommunicationNetworkFinderSingleton.instance(persistenceType),
                        new MinimumCommunicationNetworkSpanningSolverStrategy().solver(spanningStrategy));
            }
            return instance;
        }
    }
}
