package ar.edu.ungs.communications.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProbabilityShould {
    @Test
    public void throw_exception_when_is_less_than_zero () {
        assertThrows(InvalidProbability.class, () -> ProbabilityMother.build(-1d));
    }

    @Test
    public void throw_exception_when_is_less_greater_one () {
        assertThrows(InvalidProbability.class, () -> ProbabilityMother.build(2d));
    }


    @Test
    public void should_be_equals () {
        assertEquals(ProbabilityMother.build(0.5d), ProbabilityMother.build(0.5d));
    }

}
