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
        int[] result = {-1, -1};

        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);

        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int firstPos = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                firstPos = middle;
                end = middle - 1; // Narrow search to the left side
            }
        }

        return firstPos;
    }

    private int findLastPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int lastPos = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                lastPos = middle;
                start = middle + 1; // Narrow search to the right side
            }
        }

        return lastPos;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        FindFirstAndLastPositionOfElementInSortedArray_34 obj = new FindFirstAndLastPositionOfElementInSortedArray_34();
        System.out.println(Arrays.toString(obj.searchRange(arr, 8))); // Expected output: [3, 4]
        System.out.println(Arrays.toString(obj.searchRange(arr, 6))); // Expected output: [-1, -1]
    }
}
