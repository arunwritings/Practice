package data_structures.arrays.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII_219 {

    /**
     Given an integer array nums and an integer k, return true if there are two distinct
     indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     **/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII_219 containsDuplicateII219 = new ContainsDuplicateII_219();
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }
}
