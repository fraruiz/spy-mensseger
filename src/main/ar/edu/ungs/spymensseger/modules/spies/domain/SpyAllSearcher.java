package ar.edu.ungs.spymensseger.modules.spies.domain;

import java.util.List;

public final class SpyAllSearcher {
	private final SpyRepository repository;

	public SpyAllSearcher(SpyRepository repository) {
		this.repository = repository;
	}

	public List<Spy> search() {
		return repository.searchAll();
	}
}
