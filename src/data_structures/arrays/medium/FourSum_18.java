package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

    /**
     Given an array nums of n integers, return an array of all the unique quadruplets
     [nums[a], nums[b], nums[c], nums[d]] such that: 0 <= a, b, c, d < n. a, b, c, and d are distinct.
     nums[a] + nums[b] + nums[c] + nums[d] == target
     You may return the answer in any order.

     Example 1:
     Input: nums = [1,0,-1,0,-2,2], target = 0
     Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     **/

    /*
     public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Handle overflow
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
*/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        nSum(nums, 4, target, 0, nums.length - 1, new ArrayList<>(), ans);
        return ans;
    }

    // Finds n numbers that add up to the target in [l, r].
    private void nSum(int[] nums, long n, long target, int l, int r, List<Integer> path,
                      List<List<Integer>> ans) {
        if (r - l + 1 < n || target < nums[l] * n || target > nums[r] * n)
            return;
        if (n == 2) {
            // Similar to the sub procedure in 15. 3Sum
            while (l < r) {
                final int sum = nums[l] + nums[r];
                if (sum == target) {
                    path.add(nums[l]);
                    path.add(nums[r]);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                    ++l;
                    --r;
                    while (l < r && nums[l] == nums[l - 1])
                        ++l;
                    while (l < r && nums[r] == nums[r + 1])
                        --r;
                } else if (sum < target) {
                    ++l;
                } else {
                    --r;
                }
            }
            return;
        }

        for (int i = l; i <= r; ++i) {
            if (i > l && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            nSum(nums, n - 1, target - nums[i], i + 1, r, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        FourSum_18 fourSum18 = new FourSum_18();
        System.out.println(fourSum18.fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
