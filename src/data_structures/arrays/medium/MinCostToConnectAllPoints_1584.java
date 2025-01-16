package data_structures.arrays.medium;

import java.util.Arrays;

public class MinCostToConnectAllPoints_1584 {

    public int minCostConnectPoints(int[][] points) {
        int len = points.length, node = 0;
        int[] distance = new int[len];
        boolean[] visited = new boolean[len];
        Arrays.fill(distance, 100000000);
        int edges = 0, result = 0;

        while (edges < len-1) {
            visited[node] = true;
            int nextNode = -1;
            for (int i=0;i<len;i++) {
                if (visited[i]) continue;
                int currentDistance = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                distance[i] = Math.min(distance[i], currentDistance);
                if (nextNode == -1 || distance[i] <distance[nextNode]) {
                    nextNode = i;
                }
            }
            result += distance[nextNode];
            node = nextNode;
            edges++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
