package data_structures.arrays.medium;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subgrids = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char currentChar = board[i][j];
                if (currentChar == '.') {
                    continue;
                }
                int number = currentChar - '0' - 1;
                int subgridIndex = (i / 3) * 3 + j / 3;
                if (rows[i][number] || columns[j][number] || subgrids[subgridIndex][number]) {
                    return false;
                }
                rows[i][number] = true;
                columns[j][number] = true;
                subgrids[subgridIndex][number] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 validSudoku36 = new ValidSudoku_36();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '8', '6', '3', '.', '.', '3'},
                {'4', '.', '8', '3', '2', '7', '.', '.', '1'},
                {'7', '.', '.', '6', '1', '9', '.', '.', '5'},
                {'9', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'5', '9', '.', '.', '.', '6', '3', '.', '9'},
                {'3', '8', '.', '.', '5', '.', '.', '.', '4'}
        };
        boolean result = validSudoku36.isValidSudoku(board);
        System.out.println(result);
    }
}
