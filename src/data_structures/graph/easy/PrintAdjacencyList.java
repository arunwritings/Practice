package data_structures.graph.easy;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {

    /**
     Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph.
     0-based indexing is followed everywhere.
     Input: V = 5, E = 7 edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]
     Output: [[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
     Explanation:
     Node 0 is connected to 1 and 4.
     Node 1 is connected to 0,2,3 and 4.
     Node 2 is connected to 1 and 3.
     Node 3 is connected to 1,2 and 4.
     Node 4 is connected to 0,1 and 3.
     **/
    public static List<List<Integer>> printGraph(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<V;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {0, 4}, {4, 1}, {4, 3}, {1, 3}, {1, 2}, {3, 2}};
        List<List<Integer>> adjList = printGraph(V, edges);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("Node " + i + ": " + adjList.get(i));
        }
    }
}
