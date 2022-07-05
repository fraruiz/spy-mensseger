package ar.edu.ungs.communications.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommunicationRequestShould {

    @Test
    public void be_equals () {
        CommunicationRequest expected = new CommunicationRequest("first", "second", 0.5d);
        CommunicationRequest actual = new CommunicationRequest("first","second", 0.5d);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void be_opposites_equals () {
        CommunicationRequest expected = new CommunicationRequest("first","second", 0.5d);
        CommunicationRequest actual = new CommunicationRequest("second","first", 0.5d);
        Assertions.assertEquals(expected, actual);
    }
}
