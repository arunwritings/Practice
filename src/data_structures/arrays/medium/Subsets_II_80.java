package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_II_80 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i=index;i< nums.length;i++) {
            if (i>index && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Subsets_II_80 subsetsIi80 = new Subsets_II_80();
        System.out.println(subsetsIi80.subsetsWithDup(nums));
    }
}
