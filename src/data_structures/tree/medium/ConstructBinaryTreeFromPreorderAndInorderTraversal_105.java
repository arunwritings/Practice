package data_structures.tree.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int[] preorderTraversal;
    private Map<Integer, Integer> inorderIndices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        this.preorderTraversal = preorder;
        for (int i = 0; i < len; i++) {
            inorderIndices.put(inorder[i], i);
        }
        return buildTreeRecursive(0, 0, len);
    }

    private TreeNode buildTreeRecursive(int preorderStart, int inorderStart, int len) {
        if (len <= 0) return null;
        int rootVal = preorderTraversal[preorderStart];
        int rootIndex = inorderIndices.get(rootVal);
        int leftSubTreeSize = rootIndex - inorderStart;
        TreeNode leftSubTree = buildTreeRecursive(preorderStart+1, inorderStart, leftSubTreeSize);
        TreeNode rightSubTree = buildTreeRecursive(preorderStart+leftSubTreeSize+1, rootIndex+1, len-1-leftSubTreeSize);
        return new TreeNode(rootVal, leftSubTree, rightSubTree);
    }

    public static void main(String[] args) {

    }
}
