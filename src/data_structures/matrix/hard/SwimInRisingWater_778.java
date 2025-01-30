package data_structures.matrix.hard;

import java.util.Arrays;

public class SwimInRisingWater_778 {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int minHeight = grid[0][0], maxHeight = grid[0][0];
        for (int[] ints : grid) {
            for (int col = 0; col < n; col++) {
                maxHeight = Math.max(maxHeight, ints[col]);
                minHeight = Math.min(minHeight, ints[col]);
            }
        }
        int left = minHeight, right = maxHeight;
        while (left < right) {
            int m = (left+right) >> 1;
            if (dfs(grid, visited, 0, 0, m)) {
                right = m;
            } else {
                left = m+1;
            }
            for (int row=0;row<n;row++) {
                Arrays.fill(visited[row], false);
            }
        }
        return right;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int time) {
        int n = grid.length;
        if (row<0 || col<0 || row>=n || col>=n || visited[row][col] || grid[row][col] > time) return false;
        if (row == grid.length-1 && col == grid.length-1) return true;
        visited[row][col] = true;
        return dfs(grid, visited, row+1, col, time) || dfs(grid, visited, row-1, col, time)
                || dfs(grid, visited, row, col+1, time) || dfs(grid, visited, row, col-1, time);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        SwimInRisingWater_778 swimInRisingWater778 = new SwimInRisingWater_778();
        System.out.println(swimInRisingWater778.swimInWater(grid));
    }
}
