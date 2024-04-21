package data_structures.arrays;

import java.util.Arrays;

public class ConcatenationOfArray_1929 {

    /**
     Given an integer array nums of length n, you want to create an array ans of length 2n
     where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     Specifically, ans is the concatenation of two nums arrays.

     Example 1:
     Input: nums = [1,2,1]
     Output: [1,2,1,1,2,1]
     Explanation: The array ans is formed as follows:
     - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
     - ans = [1,2,1,1,2,1]
     **/
    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[2 * length];
        for (int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[i + length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = getConcatenation(new int[]{1, 2, 1});
        System.out.println("The resultant array is "+ Arrays.toString(result));
    }
}
