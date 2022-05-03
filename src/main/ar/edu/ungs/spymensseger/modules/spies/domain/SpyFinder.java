package ar.edu.ungs.spymensseger.modules.spies.domain;

public final class SpyFinder {
	private final SpyRepository repository;

	public SpyFinder(SpyRepository repository) {
		this.repository = repository;
	}

	public Spy find(String name) {
		return repository.findByName(name).orElseThrow(() -> new SpyNotExists(name));
	}
}
