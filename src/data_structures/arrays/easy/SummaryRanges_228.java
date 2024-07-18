package data_structures.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {

    /**
     Input: nums = [0,1,2,4,5,7]
     Output: ["0->2","4->5","7"]
     Explanation: The ranges are:
     [0,2] --> "0->2"
     [4,5] --> "4->5"
     [7,7] --> "7"
     **/
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges_228 summaryRanges228 = new SummaryRanges_228();
        System.out.println(summaryRanges228.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
