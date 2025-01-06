package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i=index;i< nums.length;i++) {
            current.add(nums[i]);
            backtrack(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets_78 subsets78 = new Subsets_78();
        System.out.println(subsets78.subsets(nums));
    }
}
