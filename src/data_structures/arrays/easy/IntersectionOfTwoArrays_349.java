package data_structures.arrays.easy;

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
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            num1Set.add(num);
        }
        for (int num : nums2) {
            if (num1Set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_349 intersection = new IntersectionOfTwoArrays_349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection.intersection(nums1, nums2);
        System.out.println(java.util.Arrays.toString(result));
    }
}
