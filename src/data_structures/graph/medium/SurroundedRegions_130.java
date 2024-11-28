package data_structures.graph.medium;

public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if (board == null) return;
        int rows = board.length, cols = board[0].length;
        for (int i=0;i<rows;i++) {
            if (board[i][0]=='O'){
                dfs(board,i,0);
            }
            if (board[i][cols-1] == 'O'){
                dfs(board,i,cols-1);
            }
        }
        for (int j=0;j<cols;j++) {
            if (board[0][j]=='O') {
                dfs(board, 0, j);
            }
            if (board[rows-1][j]=='O') {
                dfs(board, rows-1, j);
            }
        }
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                } else if (board[i][j]=='#') {
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        // Base cases: Stop if out of bounds or if the cell is not 'O'
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
            return;
        }

        // Mark the current cell as '#' to indicate it's connected to the boundary
        board[row][col] = '#';
        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }

    public static void main(String[] args) {
        SurroundedRegions_130 surroundedRegions130 = new SurroundedRegions_130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        surroundedRegions130.solve(board);
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
