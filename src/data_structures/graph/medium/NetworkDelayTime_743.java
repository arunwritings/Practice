package data_structures.graph.medium;

import java.util.*;

public class NetworkDelayTime_743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0],
                    key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int w1 = current[0], n1 = current[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t=w1;
            if (edges.containsKey(n1)) {
                for (int[] next : edges.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if (!visited.contains(n2)) {
                        minHeap.offer(new int[]{w1+w2, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        NetworkDelayTime_743 networkDelayTime743 = new NetworkDelayTime_743();
        System.out.println(networkDelayTime743.networkDelayTime(times, 4, 2));
    }
}
