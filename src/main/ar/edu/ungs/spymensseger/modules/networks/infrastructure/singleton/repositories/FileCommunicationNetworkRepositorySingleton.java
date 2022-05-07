package ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.repositories;

import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.FileCommunicationNetworkRepository;

public final class FileCommunicationNetworkRepositorySingleton {
    private static CommunicationNetworkRepository instance;

    private FileCommunicationNetworkRepositorySingleton() {
    }

    public static CommunicationNetworkRepository instance() {
        CommunicationNetworkRepository result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CommunicationNetworkRepository.class) {
            if (instance == null) {
                instance = new FileCommunicationNetworkRepository();
            }
            return instance;
        }
    }
}
