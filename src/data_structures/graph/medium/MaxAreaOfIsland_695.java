package data_structures.graph.medium;

public class MaxAreaOfIsland_695 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int area = 0;
        for (int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int res = 1;
        for (int[] direction : directions) {
            res += dfs(grid, r+direction[0], c+direction[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                   {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                   {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                   {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                   {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOfIsland_695 maxAreaOfIsland695 = new MaxAreaOfIsland_695();
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(grid));
    }
}
