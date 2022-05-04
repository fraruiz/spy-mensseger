package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

public abstract class Graph<T> {
	public abstract void add(Integer source, Integer destination, Number weight);

	public abstract void delete(Integer source, Integer destination);

	public abstract Boolean exists(Integer source, Integer destination);

	public abstract Set<Integer> neighbours(Integer vertex);

	public abstract Integer size();

	public Integer random() {
		return new Random().nextInt((this.size()) + 1);
	}

	protected void ensureEdgeValid(Integer source, Integer destination) {
		if (Objects.equals(source, destination)) {
			throw new IllegalArgumentException(String.format("the source <%s> can not be equals than destination <%s>", source, destination));
		}
	}

	public void ensureVertexExists(Integer vertex) {
		if (vertex < 0) {
			throw new IllegalArgumentException(String.format("the vertex <%s> can not be less than zero", vertex));
		}

		if (vertex >= size()) {
			throw new IllegalArgumentException(String.format("the vertex <%s> can not be less than <%s>", vertex, size()));
		}
	}
}