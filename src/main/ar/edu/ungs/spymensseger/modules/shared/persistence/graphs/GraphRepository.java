package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;

import java.util.Optional;

public abstract class GraphRepository<V, W extends Comparable> {
	protected GraphRepository() {
	}

	protected void persist(V source, V destination, W weight) {

	}

	protected Optional<Graph<V, W>> get() {
		return Optional.empty();
	}
}
