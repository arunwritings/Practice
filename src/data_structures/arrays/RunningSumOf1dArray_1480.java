package data_structures.arrays;

import java.util.Arrays;

public class RunningSumOf1dArray_1480 {

    /**
     Input: nums = [1,2,3,4]
     Output: [1,3,6,10]
     Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     **/
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = runningSum(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(result));
    }
}
