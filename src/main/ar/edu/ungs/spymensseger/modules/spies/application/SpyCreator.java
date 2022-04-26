package ar.edu.ungs.spymensseger.modules.spies.application;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import ar.edu.ungs.spymensseger.modules.spies.domain.SpyRepository;

public final class SpyCreator {
    private final SpyRepository repository;

    public SpyCreator(SpyRepository repository) {
        this.repository = repository;
    }

    public void create(String name) {
        Spy spy = new Spy(name);

        this.repository.save(spy);
    }
}
