package data_structures.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {

    public int orangesRotting(int[][] grid) {
        // If the grid is null or empty, return -1 as it's an invalid input
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length; // Number of rows in the grid
        int cols = grid[0].length; // Number of columns in the grid
        Queue<int[]> queue = new LinkedList<>(); // Queue to perform BFS
        int freshCount = 0; // Count of fresh oranges

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten orange to the queue
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    // Count the number of fresh oranges
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, all oranges are already rotten
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0; // Time required to rot all fresh oranges
        // Directions array to move up, down, left, and right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Perform BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of rotten oranges to process in this layer
            boolean rotted = false; // To track if any fresh orange was rotted in this layer

            for (int i = 0; i < size; i++) {
                // Dequeue a rotten orange
                int[] current = queue.poll();
                assert current != null;
                int row = current[0];
                int col = current[1];

                // Check all 4 directions for fresh oranges
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // If the neighboring cell contains a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        // Rot the fresh orange
                        grid[newRow][newCol] = 2;
                        // Add it to the queue for processing in the next minute
                        queue.offer(new int[]{newRow, newCol});
                        // Decrease the count of fresh oranges
                        freshCount--;
                        // Mark that we have rotted at least one orange
                        rotted = true;
                    }
                }
            }

            // If any fresh orange was rotted, increment the time
            if (rotted) {
                minutes++;
            }
        }

        // If there are still fresh oranges left, return -1
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges_994 rottingOranges994 = new RottingOranges_994();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(rottingOranges994.orangesRotting(grid));
    }
}
