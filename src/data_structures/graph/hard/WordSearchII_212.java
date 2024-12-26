package data_structures.graph.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_212 {

    static class Trie {
        Trie[] children = new Trie[26];
        int reference = -1;

        public void insert(String word, int reference) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (node.children[charIndex] == null) {
                    node.children[charIndex] = new Trie();
                }
                node = node.children[charIndex];
            }
            node.reference = reference;
        }
    }

    private char[][] board;
    private String[] words;
    private final List<String> foundWords = new ArrayList<>();

    int rowLength;
    int colLength;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        rowLength = board.length;
        colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                dfs(trie, i, j);
            }
        }
        return foundWords;
    }

    private void dfs(Trie trie, int i, int j) {
        int charIndex = board[i][j] - 'a';
        if (trie.children[charIndex] == null) {
            return;
        }
        trie = trie.children[charIndex];
        if (trie.reference != -1) {
            foundWords.add(words[trie.reference]);
            trie.reference = -1;
        }
        char tempChar = board[i][j];
        board[i][j] = '#';
        int[] directions = {-1,0,1,0,-1};
        for (int k = 0; k < 4;k++) {
            int newRow = i + directions[k];
            int newCol = j + directions[k+1];
            if (newRow>=0 && newRow<rowLength && newCol>=0 && newCol<colLength && board[newRow][newCol] != '#') {
                dfs(trie, newRow, newCol);
            }
        }
        board[i][j] = tempChar;
    }

    public static void main(String[] args) {
        WordSearchII_212 wordSearchII212 = new WordSearchII_212();
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(wordSearchII212.findWords(board, words));
    }
}
