package ar.edu.ungs.spymensseger.modules.networks.domain;

import ar.edu.ungs.spymensseger.modules.communications.domain.ProbabilityMother;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommunicationNetworkTest {

    @Test
    public void should_throw_exception_negative_number_of_spies() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CommunicationNetwork(-1));
    }

    @Test
    public void should_throw_exception_first_spy_negative_id() {
        CommunicationNetwork communicationNetwork = CommunicationNetworkMother.random();
        Spy firstSpy = SpyMother.build(-1, "test");
        Spy secondSpy = SpyMother.build(2, "test");

        Assertions.assertThrows(IllegalArgumentException.class, () -> communicationNetwork.add(firstSpy, secondSpy, ProbabilityMother.build(0.5d)));
    }

    @Test
    public void should_throw_exception_second_spy_negative_id() {
        CommunicationNetwork communicationNetwork = CommunicationNetworkMother.random();
        Spy firstSpy = SpyMother.build(2, "test");
        Spy secondSpy = SpyMother.build(-1, "test");

        Assertions.assertThrows(IllegalArgumentException.class, () -> communicationNetwork.add(firstSpy, secondSpy, ProbabilityMother.build(0.5d)));
    }

    @Test
    public void should_throw_exception_when_spies_are_equals() {
        CommunicationNetwork communicationNetwork = CommunicationNetworkMother.random();
        Spy firstSpy = SpyMother.build(1, "test");
        Spy secondSpy = SpyMother.build(1, "test");

        Assertions.assertThrows(IllegalArgumentException.class, () -> communicationNetwork.add(firstSpy, secondSpy, ProbabilityMother.build(0.5d)));
    }

    @Test
    public void neighbors_of_a_network_without_communications() {
        CommunicationNetwork communicationNetwork = CommunicationNetworkMother.withoutEdges(3);
        Set<Spy> expected = Collections.emptySet();

        Set<Spy> actual = communicationNetwork.neighbours(SpyMother.build(0,"spy 0"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void neighbors_of_a_network_test() {
        CommunicationNetwork communicationNetwork = CommunicationNetworkMother.undirectedRandom();
        Set<Spy> expected = new HashSet<>();
        Collections.addAll(expected, SpyMother.build(1, "spy 1"), SpyMother.build(2, "spy 2"));

        Set<Spy> actual = communicationNetwork.neighbours(SpyMother.build(0,"spy 0"));

        Assertions.assertEquals(expected, actual);
    }

}
