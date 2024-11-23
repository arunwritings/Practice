package algorithms;

public class BFS_Of_Tree {

    static class Node {
        int data;
        Node left, right;
        public Node(int val) {
            data = val;
            left = right = null;
        }
    }
    /*
    Time Complexity: O(N^2), where N is the number of nodes in the skewed tree.
    Auxiliary Space: O(N) recursion stack space used is O(N).
    Input:  A
          B   C
    Output: ABC
    */
    static void printLevelOrder(Node root) {
        int height = height(root);
        for (int i=1;i<=height;i++) {
            printCurrentLevel(root, i);
        }
    }

    static void printCurrentLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print(root.data+" ");
        else if (level > 1) {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }

    static int height(Node node) {
        if (node == null) return 0;
        else {
            int leftLength = height(node.left);
            int rightLength = height(node.right);
            if (leftLength > rightLength) {
                return (leftLength+1);
            } else {
                return (rightLength+1);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
    }
}
