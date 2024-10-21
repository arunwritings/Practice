package data_structures.arrays.medium;

public class ArithmeticSlices_413 {

    /**
     An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
     For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
     Given an integer array nums, return the number of arithmetic subarrays of nums.
     A subarray is a contiguous subsequence of the array.

     Example 1:
     Input: nums = [1,2,3,4]
     Output: 3
     Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
     **/
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3) return 0;
        int[] numArr = new int[nums.length];
        int result =0;
        for (int i=2;i<nums.length;i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                numArr[i] = 1 + numArr[i-1];
                result += numArr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArithmeticSlices_413 arithmeticSlices413 = new ArithmeticSlices_413();
        System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
