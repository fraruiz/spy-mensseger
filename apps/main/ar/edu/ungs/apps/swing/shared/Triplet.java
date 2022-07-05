package ar.edu.ungs.apps.swing.shared;

import java.util.Objects;

public class Triplet<T, S, P> {
    private final T first;
    private final S second;
    private final P third;

    public Triplet(T first, S second, P third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T first() {
        return first;
    }

    public S second() {
        return second;
    }

    public P third() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return Objects.equals(first, triplet.first) && Objects.equals(second, triplet.second) && Objects.equals(third, triplet.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
