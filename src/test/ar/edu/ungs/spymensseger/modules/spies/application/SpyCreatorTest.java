package ar.edu.ungs.spymensseger.modules.spies.application;

import ar.edu.ungs.spymensseger.modules.spies.SpiesUnitTestCase;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class SpyCreatorTest extends SpiesUnitTestCase {
    private SpyCreator creator;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        this.creator = new SpyCreator(repository);
    }

    @Test
    void should_create_a_valid_spy() {
        Spy expected = SpyMother.random();

        this.creator.create(expected.name());

        shouldSaved(expected);
    }
}