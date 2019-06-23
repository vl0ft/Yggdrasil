import org.junit.Assert;
import org.junit.Test;
import org.yggdrasil.edge.UndirectedEdge;
import org.yggdrasil.graph.Graph;
import org.yggdrasil.graph.SimpleUndirectedGraph;
import org.yggdrasil.vertex.Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Tests for Undirected graphs
 */

public class TestUndirectedGraph {

    /***
     * Add Vertex to graph
     */
    @Test
    public void addVertex() {
        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        Assert.assertTrue(graph.addVertex(new Vertex<>(1)));
    }

    /***
     * Add UndirectedEdge to graph
     */
    @Test
    public void addEdge() {
        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        Assert.assertTrue(graph.addEdge(new UndirectedEdge<>(new Vertex<>(1), new Vertex<>(2))));
    }


    /***
     * Success find path between vertixies
     */
    @Test
    public void getPathSuccess() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(3), vertices.get(4));
        UndirectedEdge<Integer> edge4 = new UndirectedEdge<>(vertices.get(4), vertices.get(5));
        UndirectedEdge<Integer> edge5 = new UndirectedEdge<>(vertices.get(4), vertices.get(6));
        UndirectedEdge<Integer> edge6 = new UndirectedEdge<>(vertices.get(4), vertices.get(8));
        UndirectedEdge<Integer> edge7 = new UndirectedEdge<>(vertices.get(7), vertices.get(9));
        UndirectedEdge<Integer> edge8 = new UndirectedEdge<>(vertices.get(4), vertices.get(9));

        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8);


        edges.forEach(graph::addEdge);

        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);
    }


    /***
     * Success find path between vertixies. Graph have more than one way to the vertex
     */
    @Test
    public void getPathSuccessManyWays() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(3), vertices.get(4));
        UndirectedEdge<Integer> edge4 = new UndirectedEdge<>(vertices.get(4), vertices.get(5));
        UndirectedEdge<Integer> edge5 = new UndirectedEdge<>(vertices.get(4), vertices.get(6));
        UndirectedEdge<Integer> edge6 = new UndirectedEdge<>(vertices.get(4), vertices.get(8));
        UndirectedEdge<Integer> edge7 = new UndirectedEdge<>(vertices.get(7), vertices.get(9));
        UndirectedEdge<Integer> edge8 = new UndirectedEdge<>(vertices.get(4), vertices.get(9));
        UndirectedEdge<Integer> edge9 = new UndirectedEdge<>(vertices.get(3), vertices.get(9));

        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9);


        edges.forEach(graph::addEdge);

        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);
    }


    /***
     * Success find path between vertixies. Graph have more than one way to the vertex
     */
    @Test
    public void getPathSuccessWithCycle() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(3), vertices.get(4));
        UndirectedEdge<Integer> edge4 = new UndirectedEdge<>(vertices.get(4), vertices.get(5));
        UndirectedEdge<Integer> edge5 = new UndirectedEdge<>(vertices.get(4), vertices.get(6));
        UndirectedEdge<Integer> edge6 = new UndirectedEdge<>(vertices.get(4), vertices.get(8));
        UndirectedEdge<Integer> edge7 = new UndirectedEdge<>(vertices.get(7), vertices.get(9));
        UndirectedEdge<Integer> edge8 = new UndirectedEdge<>(vertices.get(4), vertices.get(9));
        UndirectedEdge<Integer> edge9 = new UndirectedEdge<>(vertices.get(3), vertices.get(9));
        UndirectedEdge<Integer> edge10 = new UndirectedEdge<>(vertices.get(2), vertices.get(0));

        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10);


        edges.forEach(graph::addEdge);

        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);
    }


    /***
     * Fail find path between vertixies
     */
    @Test
    public void getPathFail() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(3), vertices.get(4));
        UndirectedEdge<Integer> edge4 = new UndirectedEdge<>(vertices.get(4), vertices.get(5));
        UndirectedEdge<Integer> edge5 = new UndirectedEdge<>(vertices.get(4), vertices.get(6));
        UndirectedEdge<Integer> edge6 = new UndirectedEdge<>(vertices.get(4), vertices.get(8));
        UndirectedEdge<Integer> edge7 = new UndirectedEdge<>(vertices.get(7), vertices.get(9));

        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7);


        edges.forEach(graph::addEdge);

        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

        Assert.assertNull(path);
    }


    /**
     * Success find path between vertixies where UndirectedEdge(1,2) == UndirectedEdge (2,1)
     */
    @Test
    public void graphIsUndirected() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(4), vertices.get(3));


        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3);


        edges.forEach(graph::addEdge);

        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(4));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);
    }

    /**
     * Success find path between vertixies where graph have a loop
     */

    @Test
    public void loop() {

        Graph<UndirectedEdge<Integer>, Integer> graph = new SimpleUndirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);


        UndirectedEdge<Integer> edge0 = new UndirectedEdge<>(vertices.get(0), vertices.get(0));
        UndirectedEdge<Integer> edge = new UndirectedEdge<>(vertices.get(0), vertices.get(1));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(vertices.get(1), vertices.get(2));
        UndirectedEdge<Integer> edge2 = new UndirectedEdge<>(vertices.get(2), vertices.get(3));
        UndirectedEdge<Integer> edge3 = new UndirectedEdge<>(vertices.get(4), vertices.get(3));


        List<UndirectedEdge<Integer>> edges = Arrays.asList(edge0, edge, edge1, edge2, edge3);


        edges.forEach(graph::addEdge);


        List<UndirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(4));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);

    }

}
