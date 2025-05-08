package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSorting {

    private final int vertices;
    private final List<List<Integer>> adjList;

    public TopologicalSorting(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for (int i=0;i<vertices;i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    private void dfs(int node, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, stack);
            }
        }
        stack.push(node);
    }

    public List<Integer> topologicalSort() {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[vertices];
        for (int i=0;i<vertices;i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        TopologicalSorting graph = new TopologicalSorting(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topoOrder = graph.topologicalSort();
        System.out.println("Topological Sort (DFS): " + topoOrder);
    }
}
