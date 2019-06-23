package org.yggdrasil.graph;

import org.yggdrasil.edge.Edge;
import org.yggdrasil.vertex.Vertex;

import java.util.*;

abstract public class AbstractGraph<R extends Edge<T>, T> implements Graph<R, T> {

    protected Map<Vertex, Set<Vertex<T>>> graph;

    AbstractGraph() {
        graph = new HashMap<>();
    }

    @Override
    public boolean addVertex(Vertex<T> vertex) {
        graph.putIfAbsent(vertex, new LinkedHashSet<>());
        return graph.containsKey(vertex);
    }

    @Override
    public boolean addEdge(R edge) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<R> getPath(Vertex<T> v1, Vertex<T> v2) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
