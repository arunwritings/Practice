package data_structures.graph.easy;

public class FindIfPathExistsInGraph_1971 {

    private int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            parent[find(edge[0])] = find(edge[1]);
        }
        return find(source) == find(destination);
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        FindIfPathExistsInGraph_1971 findIfPathExistsInGraph1971 = new FindIfPathExistsInGraph_1971();
        System.out.println(findIfPathExistsInGraph1971.validPath(3,edges, 0, 2));
    }

}