package ar.edu.ungs.spymensseger.modules.networks.application;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationRequest;

import java.util.Objects;
import java.util.Set;

public final class CommunicationNetworkRequest {
	private final Set<CommunicationRequest> network;

	public CommunicationNetworkRequest(Set<CommunicationRequest> network) {
		this.network = network;
	}

	public Set<CommunicationRequest> network() {
		return network;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CommunicationNetworkRequest that = (CommunicationNetworkRequest) o;
		return Objects.equals(network, that.network);
	}

	@Override
	public int hashCode() {
		return Objects.hash(network);
	}

	@Override
	public String toString() {
		return "CommunicationNetworkRequest{" + "network=" + network + '}';
	}
}
