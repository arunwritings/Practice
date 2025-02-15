package data_structures.strings.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumSizeSubarraySum_209 {

    /**
     Given an array of positive integers nums and a positive integer target, return the minimal length of a
     subarray
     whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

     Example 1:
     Input: target = 7, nums = [2,3,1,2,4,3]
     Output: 2
     Explanation: The subarray [4,3] has the minimal length under the problem constraint.

     Example 2:
     Input: target = 4, nums = [1,4,4]
     Output: 1
     **/
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 solution = new MinimumSizeSubarraySum_209();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
