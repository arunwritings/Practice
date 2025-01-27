package data_structures.arrays.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int numLength = nums.length;
        int[] result = new int[numLength-k+1];
        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (int i=0, j=0;i<numLength;i++) {
            if (!integerDeque.isEmpty() && i-k+1 > integerDeque.peekFirst()) {
                integerDeque.pollFirst();
            }
            while (!integerDeque.isEmpty() && nums[integerDeque.peekLast()] <= nums[i]) {
                integerDeque.pollLast();
            }
            integerDeque.offer(i);
            if (i >= k-1) {
                result[j++] = nums[integerDeque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum_239 slidingWindowMaximum239 = new SlidingWindowMaximum_239();
        System.out.println(Arrays.toString(slidingWindowMaximum239.maxSlidingWindow(nums, 3)));
    }
}
