package data_structures.graph.medium;

public class WordSearch_79 {

    private int ROWS, COLS;
    /**
     Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
     The same letter cell may not be used more than once.
     **/
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (word.length() == i) return true;
        if (r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(i) || board[r][c] == '#') return false;

        board[r][c] = '#';
        boolean result = dfs(board, word, r+1,c,i+1) || dfs(board, word, r-1,c,i+1) ||
                         dfs(board, word, r,c+1,i+1) || dfs(board, word, r,c-1,i+1);
        board[r][c] =word.charAt(i);
        return result;
    }

    public static void main(String[] args) {
        WordSearch_79 wordSearch79 = new WordSearch_79();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearch79.exist(board, word));
    }
}
