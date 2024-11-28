package data_structures.graph.medium;

public class NumberOfIslands_200 {

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int noOfIslands = 0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if (row<0 || col<0 || row>=rows || col>=cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row-1,col);//up
        dfs(grid, row+1,col);//down
        dfs(grid,row,col-1);//left
        dfs(grid,row,col+1);//right
    }

    public static void main(String[] args) {
        NumberOfIslands_200 numberOfIslands200 = new NumberOfIslands_200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numberOfIslands200.numIslands(grid));
    }
}
