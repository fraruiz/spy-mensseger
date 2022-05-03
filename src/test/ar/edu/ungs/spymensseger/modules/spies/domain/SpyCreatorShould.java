package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.modules.spies.SpiesModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class SpyCreatorShould extends SpiesModuleUnitTestCase {
	private SpyCreator creator;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
		this.creator = new SpyCreator(repository);
	}

	@Test
	void create_a_valid_spy() {
		Spy expected = SpyMother.random();

		this.creator.create(expected.name());

		shouldSaved(expected);
	}
}