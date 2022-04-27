
import GraphPkg.Graph;
import java.util.TreeSet;

/**
 * This class contains a number of utility methods that makes building graphs
 * quicker and easier.
 */
public class Utilities {

    /**
     * a method very similar to the text's to create edges from an array of
     * strings
     * @param directed whether or not the graph is directed
     * @param weighted whether or not the graph is weighted
     * @param stredges the edges represented as Strings
     * @return a new graph created from the stredges
     */
    public static Graph createGraphFromEdgeList(boolean directed, boolean weighted, String[][] stredges) {
        Graph g = new Graph(directed, weighted);

        // first pass to get sorted set of vertex labels
        TreeSet<String> labels = new TreeSet<>();
        for (String[] stredge : stredges) {
            labels.add(stredge[0]);
            labels.add(stredge[1]);
        }

        // now create vertices (in alphabetical order)
        int i = 0;
        for (String label : labels) {
            g.addVertex(i++, label);
        }

        // now add edges to the graph
        for (String[] sedge : stredges) {
            if (!weighted) {
                g.addEdge(sedge[0], sedge[1]);
            } else {
                int weight = Integer.parseInt(sedge[2]);
                g.addEdge(sedge[0], sedge[1], weight);
            }
        }
        return g;
    }

    /**
     * Returns the unweighted, directed graph from Figure 14.3 of DSAJ6.
     */
    public static Graph directedUnweightedFigure14_3() {
        String[][] edges = {
            {"BOS", "SFO"}, {"BOS", "JFK"}, {"BOS", "MIA"}, {"JFK", "BOS"},
            {"JFK", "DFW"}, {"JFK", "MIA"}, {"JFK", "SFO"}, {"ORD", "DFW"},
            {"ORD", "MIA"}, {"LAX", "ORD"}, {"DFW", "SFO"}, {"DFW", "ORD"},
            {"DFW", "LAX"}, {"MIA", "DFW"}, {"MIA", "LAX"},};
        Graph g = createGraphFromEdgeList(true, false, edges);
        return g;
    }

    /**
     * Returns the unweighted, directed graph from Figure 14.3 of DSAJ6.
     */
    public static Graph undirectedUnweightedFigure14_3() {
        String[][] edges = {
            {"BOS", "SFO"}, {"BOS", "JFK"}, {"BOS", "MIA"},
            {"JFK", "DFW"}, {"JFK", "MIA"}, {"JFK", "SFO"}, {"ORD", "DFW"},
            {"ORD", "MIA"}, {"LAX", "ORD"}, {"DFW", "SFO"},
            {"DFW", "LAX"}, {"MIA", "DFW"}, {"MIA", "LAX"},};
        Graph g = createGraphFromEdgeList(false, false, edges);
        return g;
    }

    /**
     * Returns the unweighted, directed graph from Figure 14.3 of DSAJ6.
     */
    public static Graph directedWeightedFigure14_3() {
        String[][] edges = {
            {"BOS", "SFO", "3115"}, {"BOS", "JFK", "215"}, {"BOS", "MIA", "1499"}, {"JFK", "BOS", "215"},
            {"JFK", "DFW", "1548"}, {"JFK", "MIA", "1287"}, {"JFK", "SFO", "2911"}, {"ORD", "DFW", "968"},
            {"ORD", "MIA", "1376"}, {"LAX", "ORD", "2019"}, {"DFW", "SFO", "1731"}, {"DFW", "ORD", "968"},
            {"DFW", "LAX", "1438"}, {"MIA", "DFW", "1311"}, {"MIA", "LAX", "2735"},};
        Graph g = createGraphFromEdgeList(true, true, edges);
        return g;
    }

    public static Graph undirectedWeightedFigure14_3() {
        String[][] edges = {
            {"BOS", "SFO", "3115"}, {"BOS", "JFK", "215"}, {"BOS", "MIA", "1499"},
            {"JFK", "DFW", "1548"}, {"JFK", "MIA", "1287"}, {"JFK", "SFO", "2911"}, {"ORD", "DFW", "968"},
            {"ORD", "MIA", "1376"}, {"LAX", "ORD", "2019"}, {"DFW", "SFO", "1731"},
            {"DFW", "LAX", "1438"}, {"MIA", "DFW", "1311"}, {"MIA", "LAX", "2735"},};
        Graph g = createGraphFromEdgeList(false, true, edges);
        return g;
    }

    public static Graph undirectedUnweightedFigure14_9() {
        String[][] edges = {
            {"A", "B"}, {"A", "E"}, {"A", "F"}, {"B", "C"}, {"B", "F"},
            {"C", "D"}, {"C", "G"}, {"D", "G"}, {"D", "H"}, {"E", "F"},
            {"E", "I"}, {"F", "I"}, {"G", "J"}, {"G", "K"}, {"G", "L"},
            {"H", "L"}, {"I", "J"}, {"I", "M"}, {"I", "N"}, {"J", "K"},
            {"K", "N"}, {"K", "O"}, {"L", "P"}, {"M", "N"},};
        Graph g = createGraphFromEdgeList(false, false, edges);
        return g;
    }

    /**
     * Returns the unweighted, directed graph from Figure 14.3 of DSAJ6.
     */
    public static Graph undirectedUnweightedH1() {
        String[][] edges = {
            {"BOS", "SFO"}, {"SFO", "JFK"}};
        Graph g = createGraphFromEdgeList(false, false, edges);
        return g;
    }

    /**
     * Returns the unweighted, directed graph from Figure 14.3 of DSAJ6.
     */
    public static Graph directedUnweightedFigure14_13() {
        String[][] edges = {
                {"A", "C"}, {"A", "D"}, {"B", "D"}, {"B", "F"},
                {"C", "D"}, {"C", "E"}, {"C", "H"}, {"D", "F"},
                {"E", "G"}, {"F", "G"}, {"F", "H"}, {"G", "H"},};
        Graph g = createGraphFromEdgeList(true, false, edges);
        return g;
    }

    public static Graph undirectedWeightedFromNotes() {
        String[][] edges = {
                {"A", "B", "5"}, {"B", "C", "1"}, {"C", "D", "3"}, {"D", "A", "2"}};
        Graph g = createGraphFromEdgeList(false, true, edges);
        return g;
    }

    public static Graph undirectedWeightedFigure14_14() {
        String[][] edges = {
                {"BOS", "SFO", "2704"}, {"BOS", "JFK", "187"}, {"BOS", "MIA", "1258"}, {"BOS", "ORD", "867"},
                {"JFK", "MIA", "1090"}, {"JFK", "ORD", "740"},
                {"ORD", "DFW", "802"}, {"ORD", "SFO", "1846"},
                {"SFO", "LAX", "337"}, {"SFO", "DFW", "1464"},
                {"DFW", "LAX", "1235"}, {"DFW", "MIA", "1121"},
                {"MIA", "LAX", "2342"},};
        Graph g = createGraphFromEdgeList(false, true, edges);
        return g;
    }

    public static Graph undirectedWeightedQuiz() {
        String[][] edges = {{"HNL", "LAX", "2555"}, {"LAX", "SFO", "337"},
                {"LAX", "ORD", "1743"}, {"LAX", "DFW", "1233"},
                {"SFO", "ORD", "1833"}, {"ORD", "PVD", "849"},
                {"ORD", "DFW", "849"}, {"DFW", "LGA", "1387"},
                {"PVD", "MIA", "1205"}, {"PVD", "LGA", "142"},
                {"LGA", "MIA", "1099"}, {"DFW", "MIA", "1102"}};
        Graph g = createGraphFromEdgeList(false, true, edges);
        return g;
    }
}
