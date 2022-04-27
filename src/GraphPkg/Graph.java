package GraphPkg;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class implements a simple graph data structure and some of the basic
 * graph algorithms. It is an effort to simplify what is done in the text.
 *
 */
public class Graph {

    private boolean directed;  // whether the graph is directed or not
    private boolean weighted;  // whether the graph is weighted or not

    // We maintain two maps so we can quickly look up vertices by number or
    // by name
    public HashMap<Integer, Vertex> intMap;
    public HashMap<String, Vertex> stringMap;

    /**
     * A simple constructor
     *
     * @param directed whether the graph is directed or not
     * @param weighted whether the graph is weighted or not
     */
    public Graph(boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
        intMap = new HashMap<>();
        stringMap = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int index, String label) {
        Vertex v = new Vertex(index, label);
        intMap.put(index, v);
        stringMap.put(label, v);
    }

    // Add an edge to the graph
    public void addEdge(String s1, String s2) {
        addEdge(s1, s2, 1);
    }

    // Add a weighted edge to the graph
    public void addEdge(String s1, String s2, int weight) {
        Vertex v = stringMap.get(s1);
        Vertex w = stringMap.get(s2);
        v.edgeList.add(new Edge(v, w, weight));
        if (!directed) {
            w.edgeList.add(new Edge(w, v, weight));
        }
    }

    /**
     * A vertex has an index a name, and an edgeList.
     */
    public class Vertex {
        public int index;  // the index
        public String name;  // the name
        public ArrayList<Edge> edgeList;  // the edges for this vertex

        public int pathWeight;   // used only with Dijkstras

        /**
         * A simple constructor
         *
         * @param index is the vertex's index number
         * @param name is the name associated with the vertex
         */
        public Vertex(int index, String name) {
            this.index = index;
            this.name = name;
            edgeList = new ArrayList<>();
            pathWeight = 0;
        }

        public String toString() {
            return "[V" + index +":"+ name+"]";
        }
    }

    /**
     * Our edge data structure
     */
    public class Edge {

        // Each edge has two vertices
        public Vertex[] vertices;
        // Weighted graphs also have edge weights
        public int weight;

        /**
         * A simple edge constructor
         *
         * @param v the outgoing vertex
         * @param w the incoming vertex
         */
        public Edge(Vertex v, Vertex w) {
            this (v, w, 1);
        }

        /**
         * A second constructor with an edge weight
         *
         * @param v the outgoing vertex
         * @param w the incoming vertex
         * @param weight the edge's weight
         */
        public Edge(Vertex v, Vertex w, int weight) {
            vertices = new Vertex[2];
            vertices[0] = v;
            vertices[1] = w;
            this.weight = weight;
        }

        /**
         * A toString method to make printing edges easier If the graph is
         * weighted, the edge weight is also printed
         *
         * @return the edge represented as a String
         */
        @Override
        public String toString() {
            return vertices[0].name + "-" + vertices[1].name + (weighted ? " " + weight : "");
        }
    }
}
