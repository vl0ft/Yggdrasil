import org.junit.Assert;
import org.junit.Test;
import org.yggdrasil.edge.DirectedEdge;
import org.yggdrasil.edge.UndirectedEdge;
import org.yggdrasil.vertex.Vertex;

/***
 * Tests for Edges
 */

public class TestEdge {

    /***
     * UndirectedEdge(1,2) should be equals UndirectedEdge(2,1)
     */

    @Test
    public void equalsEdge() {
        UndirectedEdge<Integer> edge = new UndirectedEdge<>(new Vertex<>(1), new Vertex<>(2));
        UndirectedEdge<Integer> edge1 = new UndirectedEdge<>(new Vertex<>(2), new Vertex<>(1));

        Assert.assertEquals(edge, edge1);
    }

    /***
     * DirectedEdge(1,2) should be equals UndirectedEdge(1,2)
     */

    @Test
    public void equalsDirectedEdge() {
        DirectedEdge<Integer> edge = new DirectedEdge<>(new Vertex<>(1), new Vertex<>(2));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(new Vertex<>(1), new Vertex<>(2));

        Assert.assertEquals(edge, edge1);
    }

    /***
     * DirectedEdge(1,2) shouldn't be equals UndirectedEdge(1,2)
     */

    @Test
    public void notEqualsDirectedEdge() {
        DirectedEdge<Integer> edge = new DirectedEdge<>(new Vertex<>(1), new Vertex<>(2));
        DirectedEdge<Integer> edge1 = new DirectedEdge<>(new Vertex<>(2), new Vertex<>(1));

        Assert.assertNotEquals(edge, edge1);
    }
}
