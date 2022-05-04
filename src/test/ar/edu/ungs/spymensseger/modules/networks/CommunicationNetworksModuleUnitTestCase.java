package ar.edu.ungs.spymensseger.modules.networks;

import ar.edu.ungs.spymensseger.modules.UnitTestCase;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetwork;
import ar.edu.ungs.spymensseger.modules.networks.domain.CommunicationNetworkRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CommunicationNetworksModuleUnitTestCase extends UnitTestCase {
	protected CommunicationNetworkRepository repository;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(CommunicationNetworkRepository.class);
	}

	public void shouldFind(CommunicationNetwork expected){
		when(this.repository.find()).thenReturn(Optional.ofNullable(expected));
	}

	protected void shouldSaved(CommunicationNetwork expected) {
		verify(this.repository, atLeastOnce()).save(expected);
	}
}
