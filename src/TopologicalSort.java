import GraphPkg.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Topological Sort
 * Program that orders the vertices so that all edges
 * are left to right
 */
public class TopologicalSort {

    /**
     * Perform the topological sort
     * @param g = the graph under consideration
     * @return an array list of vertices in sorted order
     */
    public static ArrayList<Graph.Vertex> topologicalSort(Graph g) {
        ArrayList<Graph.Vertex> result = new ArrayList<>();

        // while there are more vertices find one with in degree 0
        // and remove it and all outgoing edges from the graph.
        Collection<Graph.Vertex> vertices = g.intMap.values();
        boolean progress = true;

        while (vertices.size() > 0 && progress) {
            progress = false;
            Graph.Vertex v = null;
            for (Graph.Vertex v1 : vertices) {
                if (inDegree(g, v1) == 0) {
                    progress = true;
                    v = v1;
                    break;
                }
            }
            if (progress) {
                removeVertex(g, v);
                result.add(v);
            }
        }
        return result;
    }

    /**
     * Count the indegree of a vertex.
     * Since our data structures make this awkward, we traverse all edges, counting
     * @param g  the graph under consideration
     * @param v  the vertex we are counting for
     * @return   the indegree of v
     */
    public static int inDegree(Graph g, Graph.Vertex v) {
        int count = 0;
        for (Graph.Vertex u : g.stringMap.values()) {
            if (u != v) {
                ArrayList<Graph.Edge> edges = u.edgeList;
                for (Graph.Edge e : edges) {
                    if (e.vertices[1] == v) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Remove a vertex from the graph
     * @param g  the graph under consideration
     * @param v  the vertex to be removed
     */
    public static void removeVertex(Graph g, Graph.Vertex v) {
        System.out.println("Removing Vertex:" + v);
        g.intMap.remove(v.index);
        g.stringMap.remove(v.name);

        for (Graph.Vertex u : g.stringMap.values()) {
            Graph.Edge e = null;
            ArrayList<Graph.Edge> edges = u.edgeList;
            for (Graph.Edge e1 : edges) {
                if (e1.vertices[1] == v) {
                    e = e1;
                    break;
                }
            }
            edges.remove(e);
        }
    }

    /**
     * A nice simple main to start things running
     * @param args - not used
     */
    public static void main(String[] args) {
        Graph g = Utilities.directedUnweightedFigure14_13();
        ArrayList<Graph.Vertex> result = topologicalSort(g);
        System.out.println(result);
    }
}
