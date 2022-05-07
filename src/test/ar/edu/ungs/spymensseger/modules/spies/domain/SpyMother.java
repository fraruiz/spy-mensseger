package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.shared.domain.WordMother;

import java.util.List;

public final class SpyMother {
	public static List<Spy> randoms() {
		return List.of(random(0), random(1), random(2), random(3));
	}

	public static Spy random(Integer id) {
		return build(id, WordMother.random());
	}

	private static Spy build(Integer id, String name) {
		return new Spy(id, name);
	}
}
