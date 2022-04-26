package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.modules.spies.SpiesUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

final class DomainSpiesSearcherTest extends SpiesUnitTestCase {
    private DomainSpiesSearcher searcher;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();

        this.searcher = new DomainSpiesSearcher(repository);
    }

    @Test
    void should_search_all_spies() {
        List<Spy> expected = SpyMother.randoms();

        shouldSearchAll(expected);

        List<Spy> actual = this.searcher.search();

        assertEquals(expected, actual);
    }
}