package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.modules.spies.SpiesModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class SpyFinderShould extends SpiesModuleUnitTestCase {
	private SpyFinder finder;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();

		this.finder = new SpyFinder(repository);
	}

	@Test
	void should_find_a_spy() {
		Spy expected = SpyMother.random();

		shouldFindByName(expected);

		Spy actual = this.finder.find(expected.name());

		assertEquals(expected, actual);
	}

	@Test
	void should_throws_spy_not_exists() {
		Spy expected = SpyMother.random();

		assertThrows(SpyNotExists.class, () -> this.finder.find(expected.name()));
	}
}