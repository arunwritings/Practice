package data_structures.graph.medium;

import java.util.Arrays;

public class RedundantConnection_684 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        for (int i=0;i< parent.length;i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(parent, rank, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private boolean union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        if (p1 == p2) return false;
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    private int find(int[] parent, int n) {
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {
        RedundantConnection_684 redundantConnection684 = new RedundantConnection_684();
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(redundantConnection684.findRedundantConnection(edges)));
    }
}
