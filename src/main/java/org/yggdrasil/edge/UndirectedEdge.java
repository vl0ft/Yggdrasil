package org.yggdrasil.edge;

import org.yggdrasil.vertex.Vertex;

import java.util.Objects;

/***
 * UndirectedEdge
 * @param <T> user type
 */
public class UndirectedEdge<T> extends Edge<T> {

    public UndirectedEdge(Vertex<T> v1, Vertex<T> v2) {
        super(v1, v2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedEdge<?> edge = (UndirectedEdge<?>) o;
        return Objects.equals(getVertex1(), edge.getVertex1()) &&
                Objects.equals(getVertex2(), edge.getVertex2()) ||

                Objects.equals(getVertex1(), edge.getVertex2()) &&
                        Objects.equals(getVertex2(), edge.getVertex1())
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVertex1(), getVertex2()) +
                Objects.hash(getVertex2(), getVertex1());
    }

    @Override
    public String toString() {
        return "UndirectedEdge{" +
                "vertex1=" + getVertex1() +
                ", vertex2=" + getVertex2() +
                '}';
    }
}
