
import GraphPkg.Graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Sample code for a Breadth First Search
 */
public class BFSUndirected {
    /**
     * A Breadth First Search Algorithm
     * @param g  the graph being traversed
     * @param u  the start vertex
     * @return the spanning tree created by the breadth first search
     */
    public static ArrayList<Graph.Edge> BFS(Graph g, Graph.Vertex u) {
        HashSet<Graph.Vertex> known = new HashSet<>();
        ArrayList<Graph.Edge> tree = new ArrayList<>();
        
        // We use a queue (Linked list) to store the edges to be explored
        // Note that the text is perpetually enqueuing vertices rather than edges.
        // Edges work so much better on so many of these algorithms.
        LinkedList<Graph.Edge> ds = new LinkedList<>();
        known.add(u);

        // Initialize the stack with all of u's edges
        for (Graph.Edge e1 : u.edgeList) {
            ds.add(e1);
        }

        //Keep exploring edges until there are no more
        while (!ds.isEmpty()) {
            Graph.Edge e = ds.remove();
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
        Graph g = Utilities.undirectedUnweightedFigure14_9();

        Graph.Vertex u = g.stringMap.get("A");
        ArrayList<Graph.Edge> tree = BFS(g, u);

        for (Graph.Edge e : tree) {
            System.out.println(e);
        }
    }

}
