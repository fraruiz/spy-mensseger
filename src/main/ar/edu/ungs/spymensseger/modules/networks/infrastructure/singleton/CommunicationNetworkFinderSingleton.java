package ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.networks.domain.find.CommunicationNetworkFinder;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.repositories.FileCommunicationNetworkRepositorySingleton;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.repositories.InMemoryCommunicationNetworkRepositorySingleton;
import ar.edu.ungs.spymensseger.modules.shared.persistence.PersistenceType;

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
