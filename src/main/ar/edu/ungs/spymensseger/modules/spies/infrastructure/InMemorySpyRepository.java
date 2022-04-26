package ar.edu.ungs.spymensseger.modules.spies.infrastructure;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class InMemorySpyRepository implements SpyRepository {
    private final List<Spy> values;

    public InMemorySpyRepository() {
        this.values = new ArrayList<>();
    }

    @Override
    public void save(Spy spy) {
        if (this.values.contains(spy)) {
            return;
        }

        this.values.add(spy);
    }

    @Override
    public Optional<Spy> findByName(String name) {
        return this.values.stream().filter(spy -> spy.name().equals(name)).findFirst();
    }

    @Override
    public List<Spy> searchAll() {
        return this.values;
    }
}
