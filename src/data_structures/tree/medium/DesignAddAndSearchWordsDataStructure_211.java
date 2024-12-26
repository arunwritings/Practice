package data_structures.tree.medium;

public class DesignAddAndSearchWordsDataStructure_211 {

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public DesignAddAndSearchWordsDataStructure_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInTrie(word, root, 0);
    }

    // Helper method to perform DFS search with wildcards
    private boolean searchInTrie(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isEndOfWord; // Reached the end of the word, check if it's valid
        }
        char c = word.charAt(index);
        if (c == '.') {
            // Wildcard: Try all possible children nodes
            for (TrieNode child : node.children) {
                if (child != null && searchInTrie(word, child, index + 1)) {
                    return true; // Found a match
                }
            }
        } else {
            // Normal character: Check the corresponding child node
            TrieNode child = node.children[c - 'a'];
            return child != null && searchInTrie(word, child, index + 1); // Found a match
        }
        return false;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure_211 dataStructure = new DesignAddAndSearchWordsDataStructure_211();
        dataStructure.addWord("hello");
        dataStructure.addWord("world");
        System.out.println(dataStructure.search("hell"));
    }
}
