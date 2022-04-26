package ar.edu.ungs.spymensseger.modules.spies;

import ar.edu.ungs.spymensseger.modules.UnitTestCase;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class SpiesUnitTestCase extends UnitTestCase {
    protected SpyRepository repository;

    @BeforeEach
    protected void setUp() {
        this.repository = mock(SpyRepository.class);
    }

    protected void shouldFindByName(Spy expected) {
        when(this.repository.findByName(expected.name())).thenReturn(Optional.ofNullable(expected));
    }

    protected void shouldSearchAll(List<Spy> expected) {
        when(this.repository.searchAll()).thenReturn(expected);
    }

    protected void shouldSaved(Spy expected) {
        verify(this.repository, atLeastOnce()).save(expected);
    }
}
