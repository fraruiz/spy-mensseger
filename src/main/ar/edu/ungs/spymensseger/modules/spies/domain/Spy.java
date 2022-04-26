package ar.edu.ungs.spymensseger.modules.spies.domain;

import java.util.Objects;

public final class Spy {
    private final String name;

    public Spy(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spy spy = (Spy) o;
        return Objects.equals(name, spy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Spy{" +
                "name='" + name + '\'' +
                '}';
    }
}
