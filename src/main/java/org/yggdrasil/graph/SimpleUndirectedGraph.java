package org.yggdrasil.graph;

import org.yggdrasil.edge.UndirectedEdge;
import org.yggdrasil.vertex.Vertex;

import java.util.*;

/**
 * Undirected graph
 *
 * @param <T> user type of vertex's value
 */

public class SimpleUndirectedGraph<T> extends AbstractGraph<UndirectedEdge<T>, T> implements Graph<UndirectedEdge<T>, T> {


    public SimpleUndirectedGraph() {
        super();
    }

    @Override
    public boolean addEdge(UndirectedEdge<T> edge) {

        Vertex<T> vertex1 = edge.getVertex1();
        Vertex<T> vertex2 = edge.getVertex2();

        graph.merge(vertex1, new LinkedHashSet<>(Arrays.asList(vertex2)), (vertices, vertices2) -> {
            vertices.addAll(vertices2);
            return vertices;
        });

        graph.merge(vertex2, new LinkedHashSet<>(Arrays.asList(vertex1)), (vertices, vertices2) -> {
            vertices.addAll(vertices2);
            return vertices;
        });

        return graph.containsKey(vertex1) && graph.containsKey(vertex2);
    }

    @Override
    public List<UndirectedEdge<T>> getPath(Vertex<T> v1, Vertex<T> v2) {

        if (Objects.isNull(v1) && Objects.isNull(v2)) return Collections.emptyList();


        Set<Vertex<T>> used = new HashSet<>();

        Set<Vertex<T>> vertices = graph.get(v1);

        if (vertices == null) return Collections.emptyList();


        if (vertices.contains(v2)) return Arrays.asList(new UndirectedEdge<>(v1, v2));


        return getPath(v1, v2, used);
    }


    private List<UndirectedEdge<T>> getPath(Vertex<T> v1, Vertex<T> v2, Set<Vertex<T>> used) {

        if (Objects.isNull(v1) && Objects.isNull(v2)) return null;
        if (used.contains(v1)) return null;

        used.add(v1);

        Set<Vertex<T>> vertices = graph.get(v1);

        if (vertices == null) return null;

        vertices.removeAll(used);

        if (vertices.contains(v2)) return new LinkedList<>(Arrays.asList(new UndirectedEdge<>(v1, v2)));

        LinkedList<UndirectedEdge<T>> result = new LinkedList<>();
        for (Vertex<T> vertex : vertices) {

            List<UndirectedEdge<T>> list = getPath(vertex, v2, used);
            if (list == null) continue;

            for (UndirectedEdge<T> queue :
                    list) {
                result.addLast(queue);
            }

            result.addFirst(new UndirectedEdge<>(v1, vertex));

            return result;
        }

        return null;
    }
}
