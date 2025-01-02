package data_structures.tree.medium;

public class CountGoodNodesInBinaryTree_1448 {

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

    private int numberOfGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numberOfGoodNodes;
    }

    private void dfs(TreeNode root, int maxSoFar) {
        if (root == null) return;
        if (maxSoFar <= root.val) {
            numberOfGoodNodes++;
            maxSoFar = root.val;
        }
        dfs(root.left, maxSoFar);
        dfs(root.right, maxSoFar);
    }

    public static void main(String[] args) {

    }
}
