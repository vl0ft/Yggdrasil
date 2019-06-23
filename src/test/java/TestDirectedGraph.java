import org.junit.Assert;
import org.junit.Test;
import org.yggdrasil.edge.DirectedEdge;
import org.yggdrasil.graph.Graph;
import org.yggdrasil.graph.SimpleDirectedGraph;
import org.yggdrasil.vertex.Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Tests for Directed graphs
 */

public class TestDirectedGraph {

    /***
     * Add Vertex to graph
     */
    @Test
    public void addVertex() {
        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        Assert.assertTrue(graph.addVertex(new Vertex<>(1)));
    }

    /***
     * Add DirectedEdge to graph
     */
    @Test
    public void addEdge() {
        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        Assert.assertTrue(graph.addEdge(new DirectedEdge<>(new Vertex<>(1), new Vertex<>(2))));
    }


    /***
     * Success find path between vertixies
     */
    @Test
    public void getPathSuccess() {

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(3), vertices.get(4));
        DirectedEdge<Integer> edge4 = new DirectedEdge<>(vertices.get(4), vertices.get(5));
        DirectedEdge<Integer> edge5 = new DirectedEdge<>(vertices.get(4), vertices.get(6));
        DirectedEdge<Integer> edge6 = new DirectedEdge<>(vertices.get(4), vertices.get(8));
        DirectedEdge<Integer> edge7 = new DirectedEdge<>(vertices.get(7), vertices.get(9));
        DirectedEdge<Integer> edge8 = new DirectedEdge<>(vertices.get(4), vertices.get(9));

        List<DirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8);


        edges.forEach(graph::addEdge);

        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

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

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(3), vertices.get(4));
        DirectedEdge<Integer> edge4 = new DirectedEdge<>(vertices.get(4), vertices.get(5));
        DirectedEdge<Integer> edge5 = new DirectedEdge<>(vertices.get(4), vertices.get(6));
        DirectedEdge<Integer> edge6 = new DirectedEdge<>(vertices.get(4), vertices.get(8));
        DirectedEdge<Integer> edge7 = new DirectedEdge<>(vertices.get(7), vertices.get(9));
        DirectedEdge<Integer> edge8 = new DirectedEdge<>(vertices.get(4), vertices.get(9));
        DirectedEdge<Integer> edge9 = new DirectedEdge<>(vertices.get(3), vertices.get(9));

        List<DirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9);


        edges.forEach(graph::addEdge);

        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

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

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(3), vertices.get(4));
        DirectedEdge<Integer> edge4 = new DirectedEdge<>(vertices.get(4), vertices.get(5));
        DirectedEdge<Integer> edge5 = new DirectedEdge<>(vertices.get(4), vertices.get(6));
        DirectedEdge<Integer> edge6 = new DirectedEdge<>(vertices.get(4), vertices.get(8));
        DirectedEdge<Integer> edge7 = new DirectedEdge<>(vertices.get(7), vertices.get(9));
        DirectedEdge<Integer> edge8 = new DirectedEdge<>(vertices.get(4), vertices.get(9));
        DirectedEdge<Integer> edge9 = new DirectedEdge<>(vertices.get(3), vertices.get(9));
        DirectedEdge<Integer> edge10 = new DirectedEdge<>(vertices.get(2), vertices.get(0));

        List<DirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10);


        edges.forEach(graph::addEdge);

        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

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

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(3), vertices.get(4));
        DirectedEdge<Integer> edge4 = new DirectedEdge<>(vertices.get(4), vertices.get(5));
        DirectedEdge<Integer> edge5 = new DirectedEdge<>(vertices.get(4), vertices.get(6));
        DirectedEdge<Integer> edge6 = new DirectedEdge<>(vertices.get(4), vertices.get(8));
        DirectedEdge<Integer> edge7 = new DirectedEdge<>(vertices.get(7), vertices.get(9));

        List<DirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3, edge4, edge5, edge6, edge7);


        edges.forEach(graph::addEdge);

        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(9));

        Assert.assertNull(path);
    }

    /***
     * File find path between vertixies becase DirectedEdge(1,2) != DirectedEdge (2,1)
     */
    @Test
    public void graphIsDirected() {

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);

        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(4), vertices.get(3));


        List<DirectedEdge<Integer>> edges = Arrays.asList(edge, edge1, edge2, edge3);


        edges.forEach(graph::addEdge);

        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(4));


        Assert.assertNull(path);
    }

    /**
     * Success find path between vertixies where graph have a loop
     */

    @Test
    public void loop() {

        Graph<DirectedEdge<Integer>, Integer> graph = new SimpleDirectedGraph<>();

        List<Vertex<Integer>> vertices = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            vertices.add(new Vertex<>(i));
        }


        vertices.forEach(graph::addVertex);


        DirectedEdge<Integer> edge0 = new DirectedEdge<>(vertices.get(0), vertices.get(0));
        DirectedEdge<Integer> edge = new DirectedEdge<>(vertices.get(0), vertices.get(1));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(vertices.get(1), vertices.get(2));
        DirectedEdge<Integer> edge2 = new DirectedEdge<>(vertices.get(2), vertices.get(3));
        DirectedEdge<Integer> edge3 = new DirectedEdge<>(vertices.get(3), vertices.get(4));


        List<DirectedEdge<Integer>> edges = Arrays.asList(edge0, edge, edge1, edge2, edge3);


        edges.forEach(graph::addEdge);


        List<DirectedEdge<Integer>> path = graph.getPath(vertices.get(0), vertices.get(4));

        path.stream()
                .map(integerEdge -> String.format("%s->%s", integerEdge.getVertex1(), integerEdge.getVertex2()))
                .forEach(System.out::println);

        Assert.assertNotNull(path);

    }
}
