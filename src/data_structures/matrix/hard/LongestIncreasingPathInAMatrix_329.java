package data_structures.matrix.hard;

public class LongestIncreasingPathInAMatrix_329 {

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int LIP = 0;
        dp = new int[ROWS][COLS];
        for (int i=0;i<ROWS;i++) {
            for (int j=0;j<COLS;j++) {
                dp[i][j] = -1;
            }
        }
        for (int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                LIP = Math.max(LIP, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }
        return LIP;
    }

    private int dfs(int[][] matrix, int row, int col, int previousValue) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        if (row<0 || row>=ROWS || col<0 || col>=COLS || matrix[row][col]<=previousValue) {
            return 0;
        }
        if (dp[row][col] != -1) return dp[row][col];
        int res = 1;
        for (int[] d : directions) {
            res = Math.max(res, 1+dfs(matrix, row+d[0], col+d[1], matrix[row][col]));
        }
        return dp[row][col] = res;
    }


    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LongestIncreasingPathInAMatrix_329 l = new LongestIncreasingPathInAMatrix_329();
        System.out.println(l.longestIncreasingPath(matrix));
    }
}
