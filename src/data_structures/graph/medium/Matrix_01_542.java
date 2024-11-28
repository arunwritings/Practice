package data_structures.graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01_542 {

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] distance = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving in 4 directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX>=0 && newX<rows && newY>=0 && newY<cols && !visited[newX][newY]) {
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        Matrix_01_542 matrix01542 = new Matrix_01_542();
        int[][] result = matrix01542.updateMatrix(mat);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
