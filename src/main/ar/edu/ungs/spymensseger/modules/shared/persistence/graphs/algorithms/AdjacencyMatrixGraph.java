package ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms;

import java.util.HashSet;
import java.util.Set;

public final class AdjacencyMatrixGraph<T> extends Graph<T> {
	private final Object[][] values;

	public AdjacencyMatrixGraph(Integer vertexQuantity) {
		this.values = new Object[vertexQuantity][vertexQuantity];
	}

	@Override
	public void add(Integer source, Integer destination, Number weight){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values[source][destination] = weight;
		this.values[destination][source] = weight;
	}

	@Override
	public void delete(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values[source][destination] = null;
		this.values[destination][source] = null;
	}

	@Override
	public Boolean exists(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		return this.values[source][destination] != null && this.values[destination][source]  != null;
	}

	@Override
	public Set<Integer> neighbours(Integer vertex) {
		ensureVertexExists(vertex);

		Set<Integer> values = new HashSet<>();
		for(int source = 0; source < this.size(); ++source) {
			if(source != vertex && this.exists(vertex, source)) {
				values.add(source);
			}
		}

		return values;
	}

	@Override
	public Integer size() {
		return this.values.length;
	}
}