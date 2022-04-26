package ar.edu.ungs.spymensseger.modules.spies.infrastructure;

import ar.edu.ungs.spymensseger.modules.spies.SpiesInfrastructureTestCase;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class InMemorySpyRepositoryTest extends SpiesInfrastructureTestCase {
    private InMemorySpyRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = new InMemorySpyRepository();
    }

    @AfterEach
    void tearDown() {
        this.repository = new InMemorySpyRepository();
    }

    @Test
    void should_save_values() {
        Spy spy = SpyMother.random();

        this.repository.save(spy);
    }

    @Test
    void should_get_values() {
        Spy spy = SpyMother.random();
        List<Spy> expected = Collections.singletonList(spy);

        this.repository.save(spy);

        List<Spy> actual = this.repository.searchAll();

        assertEquals(expected, actual);
    }

    @Test
    void should_get_value() {
        Spy expected = SpyMother.random();

        this.repository.save(expected);

        Optional<Spy> actual = this.repository.findByName(expected.name());

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }
}