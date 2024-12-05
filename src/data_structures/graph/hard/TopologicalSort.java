package data_structures.graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    //DFS implementation
    /*static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<vertices;i++) {
            if (!visited[i]) {
                dfs(i,adj, visited, stack);
            }
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]){
                dfs(neighbour,adj,visited,stack);
            }
        }
        stack.push(node);
    }*/

    //Kahn's BFS Algorithm
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] inDegree = new int[V];
        ArrayList<Integer> topoSort = new ArrayList<>();
        for (ArrayList<Integer> integers : adj) {
            for (int v : integers) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoSort.add(u);
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return topoSort;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println("Topological Sort using DFS:");
        ArrayList<Integer> topoSortDFS = topologicalSort(adj);
        System.out.println(topoSortDFS);

        System.out.println("Topological Sort using Kahn's BFS:");
        ArrayList<Integer> topoSortBFS = topologicalSort(adj);
        System.out.println(topoSortBFS);
    }
}
