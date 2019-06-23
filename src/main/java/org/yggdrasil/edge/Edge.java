package org.yggdrasil.edge;

import org.yggdrasil.vertex.Vertex;

/**
 * Abstract Edge
 * @param <T> user type of vertex's value
 */

public abstract class Edge<T> {

    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    public Edge(Vertex<T> v1, Vertex<T> v2) {
        this.vertex1 = v1;
        this.vertex2 = v2;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }


    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public void setVertex1(Vertex<T> vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex<T> vertex2) {
        this.vertex2 = vertex2;
    }
}
