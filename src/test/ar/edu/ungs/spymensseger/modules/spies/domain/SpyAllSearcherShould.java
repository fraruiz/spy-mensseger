package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.modules.spies.SpiesModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class SpyAllSearcherShould extends SpiesModuleUnitTestCase {
	private SpyAllSearcher searcher;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();

		this.searcher = new SpyAllSearcher(repository);
	}

	@Test
	void search_all_spies() {
		List<Spy> expected = SpyMother.randoms();

		shouldSearchAll(expected);

		List<Spy> actual = this.searcher.search();

		assertEquals(expected, actual);
	}
}