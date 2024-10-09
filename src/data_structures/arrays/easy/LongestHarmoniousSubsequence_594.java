package data_structures.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence_594 {

    /**
     We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
     Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
     A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

     Example 1:
     Input: nums = [1,3,2,2,5,2,3,7]
     Output: 5
     Explanation:The longest harmonious subsequence is [3,2,2,2,3].
     **/
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        int result = 0;
        for (int num: freq.keySet()) {
            if (freq.containsKey(num+1)) {
                int currentLength = freq.get(num) + freq.get(num+1);
                result = Math.max(result, currentLength);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence_594 longestHarmoniousSubsequence594 = new LongestHarmoniousSubsequence_594();
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(longestHarmoniousSubsequence594.findLHS(nums));
    }
}
