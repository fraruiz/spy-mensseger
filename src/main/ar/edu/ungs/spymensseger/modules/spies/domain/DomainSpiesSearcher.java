package ar.edu.ungs.spymensseger.modules.spies.domain;

import java.util.List;

public final class DomainSpiesSearcher {
    private final SpyRepository repository;

    public DomainSpiesSearcher(SpyRepository repository) {
        this.repository = repository;
    }

    public List<Spy> search() {
        return this.repository.searchAll();
    }
}
