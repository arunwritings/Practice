package algorithms.graphAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Of_Graph {


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsResult = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsResult.add(currentNode);
            for (int neighbour : adj.get(currentNode)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfsResult;
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

        BFS_Of_Graph bfsOfGraph = new BFS_Of_Graph();
        ArrayList<Integer> bfsTraversal = bfsOfGraph.bfsOfGraph(V, adj);
        System.out.println("BFS Traversal of the Graph:");
        for (int node : bfsTraversal) {
            System.out.print(node + " ");
        }
    }
}
