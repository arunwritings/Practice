package data_structures.arrays;

import java.util.Arrays;

public class LeftAndRightSumDifferences_2574 {

    /**
     Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
     answer.length == nums.length.
     answer[i] = |leftSum[i] - rightSum[i]|.
     Where:
     leftSum[i] is the sum of elements to the left of the index i in the array nums.
     If there is no such element, leftSum[i] = 0.
     rightSum[i] is the sum of elements to the right of the index i in the array nums.
     If there is no such element, rightSum[i] = 0.
     Return the array answer.
     **/
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        // Calculate left sum
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        // Calculate right sum
        rightSum[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        // Calculate the difference
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LeftAndRightSumDifferences_2574 obj = new LeftAndRightSumDifferences_2574();
        System.out.println(Arrays.toString(obj.leftRightDifference(new int[]{10, 4, 8, 3})));
    }
}
