package data_structures.arrays;

import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget_2824 {

    /**
     Input: nums = [-1,1,2,3,1], target = 2
     Output: 3
     Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
     - (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
     - (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target
     - (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
     Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
     **/
    public static int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size();i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-6,2,5,-2,-7,-1,3);
        int result = countPairs(nums,-2);
        System.out.println(result);
    }
}
