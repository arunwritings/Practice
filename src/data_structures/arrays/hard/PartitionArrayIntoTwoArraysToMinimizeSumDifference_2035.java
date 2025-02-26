package data_structures.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference_2035 {

    static int minDifference = Integer.MAX_VALUE;

    //Brute Force TC: O(2^n) SC: O(1)
    public int minimumDifference(int[] nums) {
        findSubsets(nums, 0, 0, 0);
        return minDifference;
    }

    private void findSubsets(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            minDifference = Math.min(minDifference, Math.abs(sum1-sum2));
            return;
        }
        findSubsets(nums, index+1, sum1+nums[index], sum2);
        findSubsets(nums, index+1, sum1, sum2+nums[index]);
    }

    //DP(Meet in the Middle) TC: O(2^(N/2) log 2^(N/2)) SC: O(2^(N/2))
    public int minDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();
        int[] firstHalf = Arrays.copyOfRange(nums, 0, n);
        int[] secondHalf = Arrays.copyOfRange(nums, n, 2 * n);
        List<List<Integer>> firstHalfSubsets = generateSubsets(firstHalf);
        List<List<Integer>> secondHalfSubsets = generateSubsets(secondHalf);
        int minDiff = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> firstSums = firstHalfSubsets.get(k);
            List<Integer> secondSums = secondHalfSubsets.get(n - k);
            Collections.sort(secondSums);
            for (int sum1 : firstSums) {
                int target = (totalSum - 2 * sum1) / 2;
                int idx = Collections.binarySearch(secondSums, target);
                if (idx >= 0) {
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sum1 + secondSums.get(idx))));
                } else {
                    idx = -idx - 1;
                    if (idx < secondSums.size()) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sum1 + secondSums.get(idx))));
                    }
                    if (idx > 0) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sum1 + secondSums.get(idx - 1))));
                    }
                }
            }
        }
        return minDiff;
    }

    private static List<List<Integer>> generateSubsets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            subsets.add(new ArrayList<>());
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }
            subsets.get(count).add(sum);
        }
        return subsets;
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};
        PartitionArrayIntoTwoArraysToMinimizeSumDifference_2035 p = new PartitionArrayIntoTwoArraysToMinimizeSumDifference_2035();
        System.out.println(p.minimumDifference(nums));
        System.out.println(p.minDifference(nums));
    }
}
