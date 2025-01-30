package data_structures.arrays.hard;

public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    int coins = newNums[i - 1] * newNums[k] * newNums[j + 1];
                    coins += dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        BurstBalloons_312 burstBalloons312 = new BurstBalloons_312();
        System.out.println(burstBalloons312.maxCoins(nums));
    }
}
