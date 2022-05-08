package ar.edu.ungs.spymensseger.modules.networks.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommunicationNetworkRequestTest {

    @Test
    public void should_be_equals() {
        CommunicationNetworkRequest firstCommunicationNetworkRequest = CommunicationNetworkRequestMother.random();
        CommunicationNetworkRequest secondCommunicationNetworkRequest = CommunicationNetworkRequestMother.random();
        Assertions.assertEquals(firstCommunicationNetworkRequest, secondCommunicationNetworkRequest);
    }

}
