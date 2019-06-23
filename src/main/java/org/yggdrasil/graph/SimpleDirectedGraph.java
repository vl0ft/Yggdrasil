package org.yggdrasil.graph;

import org.yggdrasil.edge.DirectedEdge;
import org.yggdrasil.vertex.Vertex;

import java.util.*;

/**
 * Directed graph
 *
 * @param <T> user type of vertex's value
 */

public class SimpleDirectedGraph<T> extends AbstractGraph<DirectedEdge<T>, T> implements Graph<DirectedEdge<T>, T> {


    public SimpleDirectedGraph() {
        super();
    }

    @Override
    public boolean addEdge(DirectedEdge<T> edge) {

        Vertex<T> vertex1 = edge.getFrom();
        Vertex<T> vertex2 = edge.getTo();

        graph.merge(vertex1, new LinkedHashSet<>(Arrays.asList(vertex2)), (vertices, vertices2) -> {
            vertices.addAll(vertices2);
            return vertices;
        });

        return graph.containsKey(vertex1);

    }

    @Override
    public List<DirectedEdge<T>> getPath(Vertex<T> v1, Vertex<T> v2) {

        if (Objects.isNull(v1) && Objects.isNull(v2)) return Collections.emptyList();


        Set<Vertex<T>> used = new HashSet<>();

        Set<Vertex<T>> vertices = graph.get(v1);

        if (vertices == null) return Collections.emptyList();


        if (vertices.contains(v2)) return Arrays.asList(new DirectedEdge<>(v1, v2));


        return getPath(v1, v2, used);
    }


    private List<DirectedEdge<T>> getPath(Vertex<T> v1, Vertex<T> v2, Set<Vertex<T>> used) {

        if (Objects.isNull(v1) && Objects.isNull(v2)) return null;
        if (used.contains(v1)) return null;

        used.add(v1);

        Set<Vertex<T>> vertices = graph.get(v1);

        if (vertices == null) return null;

        vertices.removeAll(used);

        if (vertices.contains(v2)) return new LinkedList<>(Arrays.asList(new DirectedEdge<>(v1, v2)));

        LinkedList<DirectedEdge<T>> result = new LinkedList<>();

        for (Vertex<T> vertex : vertices) {

            List<DirectedEdge<T>> list = getPath(vertex, v2, used);
            if (list == null) continue;

            for (DirectedEdge<T> queue : list) {
                result.addLast(queue);
            }

            result.addFirst(new DirectedEdge<>(v1, vertex));

            return result;
        }

        return null;
    }
}
