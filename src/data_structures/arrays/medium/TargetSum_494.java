package data_structures.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,1);
        for (int num : nums) {
            Map<Integer, Integer> nextDP = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                nextDP.put(total+num, nextDP.getOrDefault(total+num,0)+count);
                nextDP.put(total-num, nextDP.getOrDefault(total-num,0)+count);
            }
            dp = nextDP;
        }
        return dp.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        TargetSum_494 targetSum494 = new TargetSum_494();
        int[] nums = {1,1,1,1,1};
        System.out.println(targetSum494.findTargetSumWays(nums, 3));
    }
}
