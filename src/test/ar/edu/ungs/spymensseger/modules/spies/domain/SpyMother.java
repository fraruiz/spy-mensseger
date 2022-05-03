package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.shared.domain.WordMother;

import java.util.List;

public final class SpyMother {
	public static List<Spy> randoms() {
		return List.of(random(), random(), random(), random());
	}

	public static Spy random() {
		return build(WordMother.random());
	}

	private static Spy build(String name) {
		return new Spy(name);
	}
}
