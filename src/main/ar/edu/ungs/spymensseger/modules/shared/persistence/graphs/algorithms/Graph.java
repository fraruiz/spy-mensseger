package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms;

import java.util.*;

public final class Graph<V, W extends Comparable> {
	private final Object[][] adjacencyMatrix;
	private final Map<V, Integer> positions;
	private final Set<V> vertexes;

	public Graph(Set<V> vertexes) {
		this.adjacencyMatrix = new Object[vertexes.size()][vertexes.size()];
		this.positions = new HashMap<>();
		this.vertexes = vertexes;
		initializePositions();
	}

	public void add(V source, V destination, W weight){
		ensureVertexExists(source);
		ensureVertexExists(destination);

		Integer sourcePosition = this.positions.get(source);
		Integer destinationPosition = this.positions.get(destination);

		this.adjacencyMatrix[sourcePosition][destinationPosition] = weight;
		this.adjacencyMatrix[destinationPosition][sourcePosition] = weight;
	}

	public void remove(V source, V destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);

		Integer sourcePosition = this.positions.get(source);
		Integer destinationPosition = this.positions.get(destination);

		this.adjacencyMatrix[sourcePosition][destinationPosition] = null;
		this.adjacencyMatrix[destinationPosition][sourcePosition] = null;
	}

	public Set<V> neighbours(V vertex) {
		ensureVertexExists(vertex);

		Set<V> values = new HashSet<>();
		for (var neighbourPossible: this.vertexes) {
			if(neighbourPossible != vertex && this.exists(vertex, neighbourPossible)) {
				values.add(neighbourPossible);
			}
		}

		return values;
	}

	public Optional<W> weight(V source, V destination) {
		Integer sourcePosition = this.positions.get(source);
		Integer destinationPosition = this.positions.get(destination);

		return Optional.ofNullable((W) this.adjacencyMatrix[sourcePosition][destinationPosition]);
	}

	public Set<V> vertexes() {
		return vertexes;
	}

	private boolean exists(V source, V destination) {
		Integer sourcePosition = this.positions.get(source);
		Integer destinationPosition = this.positions.get(destination);

		return this.adjacencyMatrix[sourcePosition][destinationPosition] != null &&
		       this.adjacencyMatrix[destinationPosition][sourcePosition] != null;
	}

	public Integer size() {
		return this.positions.size();
	}

	public V random() {
		Integer position = new Random().nextInt((this.size()) + 1);
		return (V) this.vertexes.toArray()[position];
	}

	public Boolean exists(V vertex) {
		return this.positions.get(vertex) != null;
	}

	private void initializePositions() {
		Integer position = 0;
		for (var vertex: vertexes) {
			this.positions.put(vertex, position);
			position++;
		}
	}

	public void ensureVertexExists(V vertex) {
		if (!exists(vertex)) {
			throw new IllegalArgumentException(String.format("the vertex <%s> not exists", vertex));
		}
	}
}