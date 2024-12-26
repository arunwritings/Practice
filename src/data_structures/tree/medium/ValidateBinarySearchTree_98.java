package data_structures.tree.medium;

public class ValidateBinarySearchTree_98 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (!(left<root.val && root.val<right)) {
            return false;
        }
        return valid(root.left, left, root.val) && valid(root.right, root.val, right);
    }

    public static void main(String[] args) {
        
    }
}
