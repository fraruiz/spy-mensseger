package ar.edu.ungs.spymensseger.modules.spies.application;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;

import java.util.Objects;

public final class SpyRequest {
	private final String name;

	public SpyRequest(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SpyRequest that = (SpyRequest) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "SpyRequest{" + "name='" + name + '\'' + '}';
	}
}
