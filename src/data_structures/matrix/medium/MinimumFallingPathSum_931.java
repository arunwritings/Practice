package data_structures.matrix.medium;

public class MinimumFallingPathSum_931 {

    //Brute Force (Recursion) TC:O(3^n), SC:O(n)
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int res = Integer.MAX_VALUE;
        for (int c = 0; c < N; c++) {
            res = Math.min(res, dfs(0, c, matrix, N));
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, int N) {
        if (r == N) return 0;
        if (c < 0 || c >= N) return Integer.MAX_VALUE;
        return matrix[r][c] + Math.min(
                Math.min(dfs(r + 1, c - 1, matrix, N), dfs(r + 1, c, matrix, N)),
                dfs(r + 1, c + 1, matrix, N)
        );
    }

    //Dynamic Programming
    public int minFallingPathSumUsingDP(int[][] matrix) {
        int N = matrix.length;
        for (int row=1;row<N;row++) {
            for (int col=0;col<N;col++) {
                int mid = matrix[row-1][col];
                int left = (col>0) ? matrix[row-1][col-1] : Integer.MAX_VALUE;
                int right = (col <N-1) ? matrix[row-1][col+1] : Integer.MAX_VALUE;
                matrix[row][col] = matrix[row][col] + Math.min(mid, Math.min(left, right));
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i=0;i<N;i++) {
            result = Math.min(result, matrix[N-1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix ={{2,1,3},{6,5,4},{7,8,9}};
        MinimumFallingPathSum_931 minimumFallingPathSum931 = new MinimumFallingPathSum_931();
        System.out.println(minimumFallingPathSum931.minFallingPathSumUsingDP(matrix));
    }
}
