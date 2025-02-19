package data_structures.arrays.medium;

public class UniquePaths_II_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePaths_II_63 uniquePathsIi63 = new UniquePaths_II_63();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsIi63.uniquePathsWithObstacles(obstacleGrid));
    }
}
