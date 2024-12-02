package data_structures.graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInADirectedGraph {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        // If all nodes are not processed, a cycle exists
        return count != V;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        CycleInADirectedGraph cycleInADirectedGraph = new CycleInADirectedGraph();
        boolean hasCycle = cycleInADirectedGraph.isCyclic(V, adj);
        System.out.println("Cycle Detected: " + hasCycle);

    }
}
