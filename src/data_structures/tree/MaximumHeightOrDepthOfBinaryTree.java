package data_structures.tree;

public class MaximumHeightOrDepthOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }
    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftLength = maxDepth(node.left);
        int rightLength = maxDepth(node.right);
        return Math.max(leftLength, rightLength) +1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(new MaximumHeightOrDepthOfBinaryTree().maxDepth(root));
    }
}
