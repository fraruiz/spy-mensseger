package ar.edu.ungs.networks;

import ar.edu.ungs.UnitTestCase;
import ar.edu.ungs.networks.domain.CommunicationNetwork;
import ar.edu.ungs.networks.domain.CommunicationNetworkRepository;
import ar.edu.ungs.networks.domain.mst.MinimumCommunicationNetworkSpanningSolver;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CommunicationNetworksModuleUnitTestCase extends UnitTestCase {
	protected CommunicationNetworkRepository repository;
	protected MinimumCommunicationNetworkSpanningSolver minimumCommunicationNetworkSpanningSolver;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(CommunicationNetworkRepository.class);
		this.minimumCommunicationNetworkSpanningSolver = mock(MinimumCommunicationNetworkSpanningSolver.class);
	}

	public void shouldFind(CommunicationNetwork expected){
		when(this.repository.find()).thenReturn(Optional.ofNullable(expected));
	}

	protected void shouldSaved(CommunicationNetwork expected) {
		verify(this.repository, atLeastOnce()).save(expected);
	}

	protected void shouldSolveMinimumCommunicationNetworkSpanning(CommunicationNetwork network, CommunicationNetwork expected) {
		when(this.minimumCommunicationNetworkSpanningSolver.solve(network)).thenReturn(expected);
	}
}
