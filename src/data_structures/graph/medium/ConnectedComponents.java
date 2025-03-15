package data_structures.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

    private final int V;
    private final List<List<Integer>> adjLIst;

    public ConnectedComponents(int vertices) {
        V = vertices;
        adjLIst = new ArrayList<>();
        for (int i=0;i<vertices;i++) {
            adjLIst.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjLIst.get(v).add(w);
        adjLIst.get(w).add(v);
    }

    public int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int neighbour : adjLIst.get(i)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {    //TC: O(V+E)
        ConnectedComponents g = new ConnectedComponents(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        System.out.println("Number of connected components: " + g.countComponents());
    }
}
