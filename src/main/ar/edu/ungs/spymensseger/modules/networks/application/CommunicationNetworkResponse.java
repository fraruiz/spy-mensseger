package ar.edu.ungs.spymensseger.modules.networks.application;

import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationResponse;
import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class CommunicationNetworkResponse {
	private final List<CommunicationResponse> communications;

	public CommunicationNetworkResponse(List<CommunicationResponse> communications) {
		this.communications = communications;
	}

	public static CommunicationNetworkResponse map(CommunicationNetwork aggregate) {
		return new CommunicationNetworkResponse(aggregate.communications()
		                                                 .stream()
		                                                 .map(CommunicationResponse::map)
		                                                 .collect(Collectors.toList()));
	}

	public List<CommunicationResponse> communications() {
		return communications;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CommunicationNetworkResponse that = (CommunicationNetworkResponse) o;
		return Objects.equals(communications, that.communications);
	}

	@Override
	public int hashCode() {
		return Objects.hash(communications);
	}

	@Override
	public String toString() {
		return "CommunicationNetworkResponse{" + "communications=" + communications + '}';
	}
}
