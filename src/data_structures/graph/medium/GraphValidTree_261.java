package data_structures.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_261 {

    public boolean validTree(int n, int[][] edges) {
        // If the number of edges is not n - 1, it cannot be a tree
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(0, -1, visited, graph)) {
            return false;
        }
        // After DFS, check if all nodes are visited (i.e., the graph is connected)
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            // If the neighbor is not visited, perform DFS on it
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, visited, graph)) {
                    return true;
                }
            }
            // If the neighbor is visited and it's not the parent, there's a cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphValidTree_261 graph = new GraphValidTree_261();
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(graph.validTree(n1, edges1));

        int n2 = 5;
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {1, 4}};
        System.out.println(graph.validTree(n2, edges2));
    }
}
