package data_structures.graph.easy;

public class GraphAndVertices {

    /**
     Given an integer n representing number of vertices. Find out how many undirected graphs
     (not necessarily connected) can be constructed out of a given n number of vertices.

     In an undirected graph with n vertices:
     The total number of possible edges is n * (n-1) / 2. This is because each pair of vertices can form an edge, and edges are not directed.
     For each edge, there are two possibilities: it is either included in the graph or excluded.
     Therefore, the total number of undirected graphs is: 2 pow(n * (n-1) / 2).
     **/
    static long count(int n) {
        int totalEdges = n * (n-1) / 2;
        return (long) Math.pow(2,totalEdges);
    }

    /**
     Since there are three possibilities (no edge, an edge in one direction, or an edge in the other direction) for each of these
     n(n−1) edges, the total number of possible directed graphs is: 3 pow (n * (n-1))
     **/
    static long directedGraphsForGivenVertices(int n) {
        int totalEdges = n * (n-1);
        return (long) Math.pow(3,totalEdges);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of Undirected Graphs constructed is "+count(n));
        System.out.println("Number of Directed Graphs constructed is "+ directedGraphsForGivenVertices(2));
    }
}
