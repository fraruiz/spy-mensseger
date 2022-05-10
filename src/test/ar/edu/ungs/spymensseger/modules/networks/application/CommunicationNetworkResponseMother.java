package ar.edu.ungs.spymensseger.modules.networks.application;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationResponse;

import java.util.HashSet;
import java.util.Set;

public class CommunicationNetworkResponseMother {

    public static CommunicationNetworkResponse random() {
        Set<CommunicationResponse> network = new HashSet<>(){{
            add(new CommunicationResponse("spy 0", "spy 1", 0.8D));
            add(new CommunicationResponse("spy 1", "spy 2", 0.4D));
            add(new CommunicationResponse("spy 2", "spy 0", 0.5D));
        }};

        return new CommunicationNetworkResponse(network);
    }
}
