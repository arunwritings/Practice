package data_structures.arrays.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    /**
     Given an array of integers nums sorted in non-decreasing order,
     find the starting and ending position of a given target value.
     If target is not found in the array, return [-1, -1].
     You must write an algorithm with O(log n) runtime complexity.

     Example 1:
     Input: nums = [5,7,7,8,8,10], target = 8
     Output: [3,4]
     **/
    public int[] searchRange(int[] nums, int target) {
       return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private int binarySearch(int[] nums, int target, boolean findFirst) {
        int start = 0, end = nums.length-1;
        int result = -1;
        while (start <= end) {
            int middle = start + (end-start)/2;
            if (nums[middle] < target) {
                start = middle+1;
            } else if (nums[middle] > target) {
                end = middle-1;
            } else {
                result = middle;
                if (findFirst) {
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        FindFirstAndLastPositionOfElementInSortedArray_34 obj = new FindFirstAndLastPositionOfElementInSortedArray_34();
        System.out.println(Arrays.toString(obj.searchRange(arr, 8))); // Expected output: [3, 4]
        System.out.println(Arrays.toString(obj.searchRange(arr, 6))); // Expected output: [-1, -1]
    }
}
