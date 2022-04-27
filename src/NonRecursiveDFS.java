
import GraphPkg.Graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Sample code of nonrecursive Depth First Search
 *
 */
public class NonRecursiveDFS {
   /**
     * A nonRecursive Depth First search
     * @param g  the graph being traversed
     * @param u  the start vertex
     * @return the spanning tree created by the search
     */
    public static ArrayList<Graph.Edge> nrDFS(Graph g, Graph.Vertex u) {
        HashSet<Graph.Vertex> known = new HashSet<>();
        ArrayList<Graph.Edge> tree = new ArrayList<>();
        
        // We use a stack to store the edges to be explored
        Stack<Graph.Edge> ds = new Stack<>();
        known.add(u);

        // Initialize the stack with all of u's edges
        for (Graph.Edge e1 : u.edgeList) {
            ds.add(e1);
        }

        // Keep going while there are more edges to explore
        while (!ds.isEmpty()) {
            Graph.Edge e = ds.pop();
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
        HashSet<Graph.Vertex> known = new HashSet<>();

        Graph.Vertex u = g.stringMap.get("A");
        ArrayList<Graph.Edge> tree = nrDFS(g, u);

        for (Graph.Edge e : tree) {
            System.out.println(e);
        }
    }


}
