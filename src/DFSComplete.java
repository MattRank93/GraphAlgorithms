import GraphPkg.Graph;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Sample code for a Depth First Search
 */
public class DFSComplete {
    
    /**
     * A recursive depth first search
     * @param g  the graph we are searching
     * @param u  the start vertex
     * @param known whether the vertex has been visited or not
     * @param tree the tree of edges created
     */
    public static void DFS(Graph g, Graph.Vertex u, HashSet<Graph.Vertex> known, ArrayList<Graph.Edge> tree) {

        known.add(u);                         // u has been discovered
        for (Graph.Edge e : u.edgeList) {     // for every outgoing edge from u
            Graph.Vertex v = e.vertices[1];
            if (!known.contains(v)) {
                tree.add(e);                      // e is the tree edge that discovered v
                known.add(v);
                DFS(g, v, known, tree);              // recursively explore from v
            }
        }
    }

    
    public static void main(String[] args) {
        Graph g = Utilities.directedUnweightedFigure14_3();
        ArrayList<Graph.Edge> tree = new ArrayList<>();
        HashSet<Graph.Vertex> known = new HashSet<>();

        for (Graph.Vertex u: g.stringMap.values()) {
            if (!known.contains(u))
               DFS(g, u, known, tree);
        }
        for (Graph.Edge e : tree) {
            System.out.println(e);
        }
    }

}
