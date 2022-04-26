package ar.edu.ungs.spymensseger.modules.spies.domain;

public final class DomainSpyFinderByName {
    private final SpyRepository repository;

    public DomainSpyFinderByName(SpyRepository repository) {
        this.repository = repository;
    }

    public Spy find(String name) {
        return this.repository.findByName(name)
                              .orElseThrow(() -> new SpyNotExists(name));
    }
}
