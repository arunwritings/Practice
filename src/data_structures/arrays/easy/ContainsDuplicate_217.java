package data_structures.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

    /**
     Given an integer array nums, return true if any value appears at least twice in the array,
     and return false if every element is distinct.
     **/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_217 containsDuplicate217 = new ContainsDuplicate_217();
        System.out.println(containsDuplicate217.containsDuplicate(new int[]{1,2,3,1}));
    }
}
