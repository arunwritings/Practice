package data_structures.arrays.medium;

public class SearchInRotatedSortedArray_II_81 {

    /**
     There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
     Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
     such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
     Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
     You must decrease the overall operation steps as much as possible.

     Example 1:
     Input: nums = [2,5,6,0,0,1,2], target = 0
     Output: true
     **/
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[start] == nums[middle] && nums[middle] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[middle]) {
                if (nums[start] <= target && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_II_81 search = new SearchInRotatedSortedArray_II_81();
        int[] arr = new int[]{2,5,6,0,0,1,2};
        System.out.println(search.search(arr, 0));
    }
}
