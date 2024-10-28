package data_structures.arrays.medium;

import java.util.Arrays;

public class SortColors_75 {

    /**
     Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     You must solve this problem without using the library's sort function.

     Example 1:
     Input: nums = [2,0,2,1,1,0]
     Output: [0,0,1,1,2,2]
     **/
    public void sortColors(int[] nums) {
        int start = 0, middle = 0; int end = nums.length-1;
        while (middle <= end) {
            if (nums[middle] == 0) {
                swap(nums,start,middle);
                start++;
                middle++;
            } else if (nums[middle] == 1)  {
                middle++;
            } else {
                swap(nums, middle, end);
                end--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors_75 sortColors75 = new SortColors_75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
