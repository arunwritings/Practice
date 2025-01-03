package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II_40 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> combinations = new ArrayList<>();
    private int[] sortedCandidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sortedCandidates = candidates;
        backtrack(0, target);
        return result;
    }

    private void backtrack(int startIndex, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
        }
        if (startIndex >= sortedCandidates.length || target < sortedCandidates[startIndex]) return;
        for (int i=startIndex;i< sortedCandidates.length;i++) {
            if (i>startIndex && sortedCandidates[i] == sortedCandidates[i-1]) continue;
            combinations.add(sortedCandidates[i]);
            backtrack(i+1, target-sortedCandidates[i]);
            combinations.remove(combinations.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_II_40 combinationSumIi40 = new CombinationSum_II_40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSumIi40.combinationSum2(candidates, target));
    }
}
