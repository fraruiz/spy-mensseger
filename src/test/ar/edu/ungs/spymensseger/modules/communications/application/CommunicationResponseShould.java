package ar.edu.ungs.spymensseger.modules.communications.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CommunicationResponseShould {

    @Test
    public void be_equals() {
        CommunicationRequest firstCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);
        CommunicationRequest secondCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);

        Assertions.assertEquals(firstCommunicationRequest, secondCommunicationRequest);
    }

    @Test
    public void be_opposites_equals() {
        CommunicationRequest firstCommunicationRequest = new CommunicationRequest("second", "first", 0.5d);
        CommunicationRequest secondCommunicationRequest = new CommunicationRequest("first", "second", 0.5d);

        Assertions.assertEquals(firstCommunicationRequest, secondCommunicationRequest);
    }
}
