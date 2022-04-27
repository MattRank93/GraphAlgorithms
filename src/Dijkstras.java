
import GraphPkg.Graph;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Sample program illustrating Prim's algorithm
 *
 */
public class Dijkstras {

    /**
     * Prim's algorithm is very similar to breadth first search, but assumes the
     * edges have weights, so we use a priority queue rather than a queue.
     *
     * @param g the graph being traversed
     * @param u the start vertex
     * @return the spanning tree created by Dijkstras algorithm
     */
    public static ArrayList<Graph.Edge> dijkstras(Graph g, Graph.Vertex u) {
        HashSet<Graph.Vertex> known = new HashSet<>();
        ArrayList<Graph.Edge> tree = new ArrayList<>();
        
        // We use a priority queue based on path weight to store the edges
        // to be explored
        PriorityQueue<Graph.Edge> ds = new PriorityQueue<>(10, new DijkstrasComparator());
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
                v.pathWeight = e.vertices[0].pathWeight + e.weight;
                for (Graph.Edge e2 : v.edgeList) {
                    ds.add(e2);
                }
            }
        }
        return tree;
    }

    private static class DijkstrasComparator implements Comparator<Graph.Edge> {
      public int compare(Graph.Edge e1, Graph.Edge e2) {
            return (e1.vertices[0].pathWeight + e1.weight) - (e2.vertices[0].pathWeight + e2.weight);
        }
    }

    public static void main(String[] args) {
        //Graph g = Utilities.undirectedWeightedFigure14_14();
        Graph g = Utilities.undirectedWeightedQuiz();
        HashSet<Graph.Vertex> known = new HashSet<>();

        Graph.Vertex u = g.stringMap.get("HNL");
        //Graph.Vertex u = g.stringMap.get("A");
        ArrayList<Graph.Edge> tree = dijkstras(g, u);

        for (Graph.Edge e : tree) {
            System.out.println(e);
        }
    }
}
