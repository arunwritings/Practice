package data_structures.math.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens_51 {

    private final List<List<String>> solutions = new ArrayList<>();
    private int[] columns;
    private int[] diagonals;
    private int[] antiDiagonals;
    private String[][] board;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        columns = new int[n];
        diagonals = new int[2*n];
        antiDiagonals = new int[2*n];
        board = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        dfs(0);
        return solutions;
    }

    private void dfs(int row) {
        if (row == size) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                solution.add(String.join("", board[i]));
            }
            solutions.add(solution);
            return;
        }
        for (int i=0;i<size;i++) {
            if (columns[i]+diagonals[i+row]+antiDiagonals[size-row+i] == 0) {
                board[row][i] = "Q";
                columns[i] = diagonals[i+row] = antiDiagonals[size-row+i] = 1;
                dfs(row+1);
                columns[i] = diagonals[i+row] = antiDiagonals[size-row+i] =0;
                board[row][i] = ".";
            }
        }
    }

    public static void main(String[] args) {
        N_Queens_51 nQueens51 = new N_Queens_51();
        System.out.println(nQueens51.solveNQueens(4));
    }
}
