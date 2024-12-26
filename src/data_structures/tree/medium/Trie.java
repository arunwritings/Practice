package data_structures.tree.medium;

public class Trie {

    private final Trie[] children;
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        Trie currentNode = this;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Trie();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie currentNode = this;
        for (char letter : prefix.toCharArray()) {
            int index = letter - 'a';
            if (currentNode.children[index] == null) {
                return null;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("world"));
        System.out.println(trie.startsWith("hell"));
    }
}
