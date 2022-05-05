package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.graphs;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.communications.domain.Probability;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.GraphRepository;
import ar.edu.ungs.spymensseger.modules.shared.persistence.graphs.algorithms.Graph;
import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class GraphCommunicationNetworkRepository extends GraphRepository<Spy, Probability> implements CommunicationNetworkRepository {
	public GraphCommunicationNetworkRepository() {
		super();
	}

	@Override
	public void save(CommunicationNetwork network) {
		network.communications()
		       .forEach(communication -> super.persist(communication.firstSpy(),
		                                               communication.secondSpy(),
		                                               communication.probability()));
	}

	@Override
	public Optional<CommunicationNetwork> find() {
		Optional<Graph<Spy, Probability>> optionalGraph = super.get();

		if (optionalGraph.isEmpty()) {
			return Optional.empty();
		}

		Graph<Spy, Probability> graph = optionalGraph.get();
		List<Communication> communications = new ArrayList<>();

		for (var source: graph.vertexes()) {
			for (var destination: graph.neighbours(source)) {
				graph.weight(source, destination)
				     .ifPresent(probability -> communications.add(new Communication(source, destination, probability)));
			}
		}

		CommunicationNetwork network = new CommunicationNetwork(communications);
		return Optional.of(network);
	}
}
