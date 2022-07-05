package ar.edu.ungs.networks.infrastructure.singleton;

import ar.edu.ungs.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.networks.domain.find.CommunicationNetworkFinder;
import ar.edu.ungs.networks.infrastructure.singleton.repositories.FileCommunicationNetworkRepositorySingleton;
import ar.edu.ungs.networks.infrastructure.singleton.repositories.InMemoryCommunicationNetworkRepositorySingleton;
import ar.edu.ungs.persistence.PersistenceType;

public final class CommunicationNetworkFinderSingleton {
    private static volatile CommunicationNetworkFinder instance;

    private CommunicationNetworkFinderSingleton() {
    }

    public static CommunicationNetworkFinder instance(PersistenceType persistenceType) {
        CommunicationNetworkFinder result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CommunicationNetworkFinder.class) {
            if (instance == null) {
                CommunicationNetworkRepository repository = persistenceType.equals(PersistenceType.IN_MEMORY)
                                                                            ? InMemoryCommunicationNetworkRepositorySingleton.instance()
                                                                            : FileCommunicationNetworkRepositorySingleton.instance();

                instance = new CommunicationNetworkFinder(repository);
            }
            return instance;
        }
    }
}
