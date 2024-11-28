package data_structures.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves_1020 {

    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i=0;i<rows;i++) {
            if (grid[i][0]==1) {
                bfs(grid, i, 0);
            }
            if (grid[i][cols-1]==1) {
                bfs(grid, i, cols-1);
            }
        }
        for (int j=0;j<cols;j++) {
            if (grid[0][j] == 1) {
                bfs(grid, 0, j);
            }
            if (grid[rows-1][j]==1) {
                bfs(grid, rows-1,j);
            }
        }
        int enclaves = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] == 1) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    private void bfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Define directions for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0; // Mark the cell as visited (water)
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] direction : directions) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfEnclaves_1020 numberOfEnclaves1020 = new NumberOfEnclaves_1020();
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        // Output the number of enclaves
        int result = numberOfEnclaves1020.numEnclaves(grid);
        System.out.println("Number of enclaves: " + result);
    }
}
