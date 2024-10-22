package data_structures.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

    /**
     Given two integer arrays nums1 and nums2, return an array of their intersection.
     Each element in the result must be unique and you may return the result in any order.

     Example 1:
     Input: nums1 = [1,2,2,1], nums2 = [2,2]
     Output: [2]
     **/
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] tempResult = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (index == 0 || tempResult[index - 1] != nums1[i]) {
                    tempResult[index++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(tempResult, 0, index);
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_349 intersection = new IntersectionOfTwoArrays_349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection.intersection(nums1, nums2);
        System.out.println(java.util.Arrays.toString(result));
    }
}
