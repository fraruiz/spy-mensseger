package ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton;

import ar.edu.ungs.spymensseger.modules.networks.application.save.CommunicationNetworkSaver;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.repositories.InMemoryCommunicationNetworkRepositorySingleton;

public final class CommunicationNetworkSaverSingleton {
    private static volatile CommunicationNetworkSaver instance;

    private CommunicationNetworkSaverSingleton() {
    }

    public static CommunicationNetworkSaver instance() {
        CommunicationNetworkSaver result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CommunicationNetworkSaver.class) {
            if (instance == null) {
                instance = new CommunicationNetworkSaver(InMemoryCommunicationNetworkRepositorySingleton.instance());
            }
            return instance;
        }
    }
}
