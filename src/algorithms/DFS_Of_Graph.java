package algorithms;

import java.util.ArrayList;

public class DFS_Of_Graph {

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsResult = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfs(0, adj, visited, dfsResult);
        return dfsResult;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsResult) {
        visited[node] = true;
        dfsResult.add(node);
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, dfsResult);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(4);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(4).add(3);

        DFS_Of_Graph graph = new DFS_Of_Graph();
        ArrayList<Integer> dfsTraversal = graph.dfsOfGraph(adj);
        System.out.println("DFS Traversal of the Graph:");
        for (int node : dfsTraversal) {
            System.out.print(node + " ");
        }
    }
}
