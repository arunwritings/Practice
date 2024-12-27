package data_structures.arrays.easy;


import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 != stone2) {
                pq.add(stone1 - stone2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        LastStoneWeight_1046 lastStoneWeight_1046 = new LastStoneWeight_1046();
        System.out.println(lastStoneWeight_1046.lastStoneWeight(stones));
    }
}
