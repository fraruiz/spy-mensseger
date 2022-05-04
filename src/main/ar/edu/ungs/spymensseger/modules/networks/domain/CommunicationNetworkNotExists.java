package ar.edu.ungs.spymensseger.modules.networks.domain;

public final class CommunicationNetworkNotExists extends RuntimeException {
	public CommunicationNetworkNotExists() {
		super("the network <%s> not exists");
	}
}
