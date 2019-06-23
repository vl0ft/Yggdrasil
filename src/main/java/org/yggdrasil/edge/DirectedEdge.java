package org.yggdrasil.edge;

import org.yggdrasil.vertex.Vertex;

import java.util.Objects;

/***
 * DirectedEdge
 * @param <T> user type
 */

public class DirectedEdge<T> extends Edge<T> {


    public DirectedEdge(Vertex<T> from, Vertex<T> to) {
        super(from, to);
    }

    public void setFrom(Vertex<T> from) {
        this.setVertex1(from);
    }

    public void setTo(Vertex<T> to) {
        this.setVertex2(to);
    }

    public Vertex<T> getFrom() {
        return getVertex1();
    }

    public Vertex<T> getTo() {
        return getVertex2();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedEdge<?> edge = (DirectedEdge<?>) o;
        return Objects.equals(getTo(), edge.getTo()) &&
                Objects.equals(getFrom(), edge.getFrom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo());
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "from=" + getFrom() +
                ", to=" + getTo() +
                '}';
    }
}
