package data_structures.graph.medium;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {

    private int[] parent;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int vertex1 = edge[0], vertex2 = edge[1];
            union(vertex1, vertex2);
        }
        int count = 0;
        for (int i=0;i<n;i++) {
            if (i == find(i)) {
                count++;
            }
        }
        return count;
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        parent[root1] = root2;
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph_323 solution = new NumberOfConnectedComponentsInAnUndirectedGraph_323();
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(n1, edges1));
    }
}
