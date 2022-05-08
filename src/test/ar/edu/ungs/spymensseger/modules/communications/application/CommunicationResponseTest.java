package ar.edu.ungs.spymensseger.modules.communications.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CommunicationResponseTest {

    @Test
    public void should_be_equals() {
        CommunicationRequest firstCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);
        CommunicationRequest secondCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);

        Assertions.assertEquals(firstCommunicationRequest, secondCommunicationRequest);
    }

    @Test
    public void opposites_should_be_equals() {
        CommunicationRequest firstCommunicationRequest = new CommunicationRequest("second", "first", 0.5d);
        CommunicationRequest secondCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);

        Assertions.assertEquals(firstCommunicationRequest, secondCommunicationRequest);
    }
}
