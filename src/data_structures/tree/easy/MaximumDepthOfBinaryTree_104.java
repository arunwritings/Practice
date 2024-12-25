package data_structures.tree.easy;

import algorithms.treeAlgos.BFS_Of_Tree;

public class MaximumDepthOfBinaryTree_104 {

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

    public int maxDepth(TreeNode root) {
        return height(root);
    }

    static int height(TreeNode node) {
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
        
    }
}
