package ar.edu.ungs.spymensseger.modules.communications.domain;

import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommunicationTest {

    @Test
    public void should_be_equals() {
        Communication firstCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.5d));
        Communication secondCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.5d));

        Assertions.assertEquals(firstCommunication, secondCommunication);
    }

    @Test
    public void opposites_should_be_equals() {
        Communication firstCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.5d));
        Communication secondCommunication = CommunicationMother.build(SpyMother.random(1), SpyMother.random(0), ProbabilityMother.build(0.5d));

        Assertions.assertEquals(firstCommunication, secondCommunication);
    }

    @Test
    public void should_be_less_than_other_communication() {
        Communication firstCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.5d));
        Communication secondCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.9d));

        Assertions.assertEquals(-1, firstCommunication.compareTo(secondCommunication));
    }


    @Test
    public void should_be_greater_than_other_communication() {
        Communication firstCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.9d));
        Communication secondCommunication = CommunicationMother.build(SpyMother.random(0), SpyMother.random(1), ProbabilityMother.build(0.5d));

        Assertions.assertEquals(1, firstCommunication.compareTo(secondCommunication));
    }
}
