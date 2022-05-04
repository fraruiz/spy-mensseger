package ar.edu.ungs.spymensseger.modules.networks.domain;

import ar.edu.ungs.spymensseger.modules.communications.domain.Communication;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CommunicationNetwork {
	private final List<Communication> communications;

	public CommunicationNetwork() {
		this.communications = Collections.emptyList();
	}

	public CommunicationNetwork(List<Communication> communications) {
		this.communications = communications;
	}

	public List<Communication> communications() {
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
		CommunicationNetwork that = (CommunicationNetwork) o;
		return Objects.equals(communications, that.communications);
	}

	@Override
	public int hashCode() {
		return Objects.hash(communications);
	}

	@Override
	public String toString() {
		return "CommunicationNetwork{" + "communications=" + communications + '}';
	}
}
