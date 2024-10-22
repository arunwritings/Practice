package data_structures.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays_II_350 {

    /**
     Given two integer arrays nums1 and nums2, return an array of their intersection.
     Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

     Example 1:
     Input: nums1 = [1,2,2,1], nums2 = [2,2]
     Output: [2,2]
     **/
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i< nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                result.add(nums1[i]);i++;j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_II_350 intersection = new IntersectionOfTwoArrays_II_350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
