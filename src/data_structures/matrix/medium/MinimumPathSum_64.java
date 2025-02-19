package data_structures.matrix.medium;

public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) { // column index is 0, we have to move downwards
                    dp[j] += grid[i][j];
                } else if (i == 0) { // row index is 0, we have to move rightwards
                    dp[j] = dp[j - 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum_64 minimumPathSum64 = new MinimumPathSum_64();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minimumPathSum64.minPathSum(grid));
    }
}
