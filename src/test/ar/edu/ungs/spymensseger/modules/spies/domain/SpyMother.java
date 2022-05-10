package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.modules.shared.domain.WordMother;

import java.util.List;
import java.util.Set;

public final class SpyMother {

	public static Set<Spy> randoms() {
		return randoms(0);
	}
	public static Set<Spy> randoms(Integer fromId) {
		var first = random(fromId);
		fromId++;
		var second = random(fromId);
		fromId++;
		var third = random(fromId);

		return Set.of(first, second, third);
	}

	public static Spy random(Integer id) {
		return build(id, WordMother.random());
	}

	public static Spy build(Integer id, String name) {
		return new Spy(id, name);
	}
}
