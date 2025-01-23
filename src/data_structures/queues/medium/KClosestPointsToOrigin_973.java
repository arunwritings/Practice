package data_structures.queues.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            priorityQueue.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        for (int i=0;i<k;i++) {
            int[] point = priorityQueue.poll();
            assert point != null;
            result[i] = new int[]{point[1], point[2]};
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        KClosestPointsToOrigin_973 closestPointsToOrigin973 = new KClosestPointsToOrigin_973();
        System.out.println(Arrays.deepToString(closestPointsToOrigin973.kClosest(points, 2)));
    }
}
