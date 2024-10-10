package data_structures.arrays.easy;

public class MaximumAverageSubArray_I_643 {

    /**
     You are given an integer array nums consisting of n elements, and an integer k.
     Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     Any answer with a calculation error less than 10-5 will be accepted.

     Example 1:
     Input: nums = [1,12,-5,-6,50,3], k = 4
     Output: 12.75000
     Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     **/
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            System.out.println("Array length cannot be less than window length");
            return -1;
        }
        double maxAverageSum = 0.0, windowSum = 0.0;
        for (int i=0;i<k;i++) {
            windowSum += nums[i];
        }
        maxAverageSum = windowSum;
        for (int i=k;i< nums.length;i++) {
            windowSum += nums[i] - nums[i-k];
            maxAverageSum = Math.max(windowSum, maxAverageSum);
        }
        return maxAverageSum/k;
    }

    public static void main(String[] args) {
        MaximumAverageSubArray_I_643 maximumAverageSubArrayI643 = new MaximumAverageSubArray_I_643();
        int[] arr = new int[]{1,12,-5,-6,50,3};
        System.out.println(maximumAverageSubArrayI643.findMaxAverage(arr,4));
    }
}
