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

    /**
     * Add Vertex to graph
     *
     * @param vertex
     * @return return true if graph have vertex
     */
    boolean addVertex(Vertex<T> vertex);

    /**
     * Add Edge to graph
     *
     * @param edge
     * @return return true if graph have vertex from edge
     */

    boolean addEdge(R edge);

    /**
     * Get path between two of vertexies
     * @param v1
     * @param v2
     * @return return list of edge if path exists or null
     */

    List<R> getPath(Vertex<T> v1, Vertex<T> v2);

}
