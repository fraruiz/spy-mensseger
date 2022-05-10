package ar.edu.ungs.spymensseger.modules.networks.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommunicationNetworkResponseTest {

    @Test
    public void should_be_equals() {
        CommunicationNetworkResponse firstCommunicationNetworkRequest = CommunicationNetworkResponseMother.random();
        CommunicationNetworkResponse secondCommunicationNetworkRequest = CommunicationNetworkResponseMother.random();
        Assertions.assertEquals(firstCommunicationNetworkRequest, secondCommunicationNetworkRequest);
    }

}
