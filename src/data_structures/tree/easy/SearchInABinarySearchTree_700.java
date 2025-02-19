package data_structures.tree.easy;

public class SearchInABinarySearchTree_700 {

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
    
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) return root;
        else if (root.val < val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {

    }
}
