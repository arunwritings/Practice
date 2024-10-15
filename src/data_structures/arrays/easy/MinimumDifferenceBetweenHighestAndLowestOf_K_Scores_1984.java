package data_structures.arrays.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOf_K_Scores_1984 {

    /**
     Let's assume we have the following array {20, 200,300, 1000 } and that k is 3
     we would need to compare subarrays of size k and get the minimum value out of the subtraction between the lowest and highest number of that subarray.
     To illustrate:
     {20,200, 300} the difference between the highest (300) and lowest (20) number will be 280
     {200, 300, 1000} the difference between the highest (1000) and lowest (200) will be 800
     That's it there are not more subarrays of size K and so we compare 800 and 280 and the smallest difference is 280.
     Hopefully this makes this problem a little more clear is actually very simple, but poorly described purposely I believe.
     **/
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 0 || k == 1) return 0;
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int difference = nums[i + k - 1] - nums[i];
            minDifference = Math.min(minDifference, difference);
        }
        return minDifference;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOf_K_Scores_1984 obj = new MinimumDifferenceBetweenHighestAndLowestOf_K_Scores_1984();
        System.out.println(obj.minimumDifference(new int[]{9,4,1,7},2));
    }
}
