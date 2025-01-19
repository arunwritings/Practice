package data_structures.arrays.medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();
        for (int num : nums) {
            minimumHeap.offer(num);
            if (minimumHeap.size() > k) {
                minimumHeap.poll();
            }
        }
        return minimumHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 kthLargestElementInAnArray215 = new KthLargestElementInAnArray_215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargestElementInAnArray215.findKthLargest(nums, 4));
    }
}
