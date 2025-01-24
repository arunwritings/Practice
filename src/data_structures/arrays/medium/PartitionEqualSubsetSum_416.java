package data_structures.arrays.medium;

public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        if (sum(nums) % 2 != 0) {
            return false;
        }

        int target = sum(nums) / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    private int sum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        PartitionEqualSubsetSum_416 partitionEqualSubsetSum416 = new PartitionEqualSubsetSum_416();
        System.out.println(partitionEqualSubsetSum416.canPartition(nums));
    }
}
