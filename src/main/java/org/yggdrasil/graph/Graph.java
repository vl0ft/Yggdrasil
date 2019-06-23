package org.yggdrasil.graph;

import org.yggdrasil.edge.Edge;
import org.yggdrasil.vertex.Vertex;

import java.util.List;

/**
 * Graph
 *
 * @param <R>
 * @param <T>
 */
public interface Graph<R extends Edge<T>, T> {


    boolean addVertex(Vertex<T> vertex);

    boolean addEdge(R edge);

    List<R> getPath(Vertex<T> v1, Vertex<T> v2);

}
