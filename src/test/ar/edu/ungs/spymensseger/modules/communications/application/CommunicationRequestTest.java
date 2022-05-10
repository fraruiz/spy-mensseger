package ar.edu.ungs.spymensseger.modules.communications.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CommunicationRequestTest {

    @Test
    public void should_be_equals () {
        CommunicationRequest expected = new CommunicationRequest("first","second", 0.5d);
        CommunicationRequest actual = new CommunicationRequest("first","second", 0.5d);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void opposites_should_be_equals () {
        CommunicationRequest expected = new CommunicationRequest("first","second", 0.5d);
        CommunicationRequest actual = new CommunicationRequest("second","first", 0.5d);
        Assertions.assertEquals(expected, actual);
    }




}
