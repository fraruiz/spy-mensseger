package ar.edu.ungs.spymensseger.modules.spies.domain;

public final class SpyCreator {
	private final SpyRepository repository;

	public SpyCreator(SpyRepository repository) {
		this.repository = repository;
	}

	public void create(String name) {
		Spy spy = new Spy(name);

		repository.save(spy);
	}
}
