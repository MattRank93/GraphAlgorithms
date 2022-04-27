
import GraphPkg.Graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Sample program illustrating Prim's algorithm
 *
 */
public class Prims {

    /**
     * Prim's algorithm is very similar to breadth first search, but assumes the
     * edges have weights, so we use a priority queue rather than a queue.
     *
     * @param g the graph being traversed
     * @param u the start vertex
     * @return the spanning created by prims
     */
    public static ArrayList<Graph.Edge> prims(Graph g, Graph.Vertex u) {

        HashSet<Graph.Vertex> known = new HashSet<>();
        ArrayList<Graph.Edge> tree = new ArrayList<>();
        
        // We use a priority queue to store the edges to be explored
        PriorityQueue<Graph.Edge> ds = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        known.add(u);

        // Initialize the stack with all of u's edges
        for (Graph.Edge e1 : u.edgeList) {
            ds.add(e1);
        }

        // Keep going until there are no more edges to explore
        while (!ds.isEmpty()) {
            Graph.Edge e = ds.poll();
            Graph.Vertex v = e.vertices[1];
            if (!known.contains(v)) {
                tree.add(e);                      // e is the tree edge that discovered v
                known.add(v);
                for (Graph.Edge e2 : v.edgeList) {
                    ds.add(e2);
                }
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        Graph g = Utilities.directedWeightedFigure14_3();
        HashSet<Graph.Vertex> known = new HashSet<>();

        Graph.Vertex u = g.stringMap.get("BOS");
        ArrayList<Graph.Edge> tree = prims(g, u);

        for (Graph.Edge e : tree) {
            System.out.println(e);
        }
    }
}
