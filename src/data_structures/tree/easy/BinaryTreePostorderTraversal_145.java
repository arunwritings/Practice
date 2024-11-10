package data_structures.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {

    static class TreeNode {
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

    /*INPUT: A
    *      B   C
    * OUTPUT: BCA*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postOrderHelper(root, answer);
        return answer;
    }

    private void postOrderHelper(TreeNode root, List<Integer> answer) {
        if (root == null){
            return;
        }
        postOrderHelper(root.left, answer);
        postOrderHelper(root.right, answer);
        answer.add(root.val);
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal_145 binaryTreePostorderTraversal145 = new BinaryTreePostorderTraversal_145();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(binaryTreePostorderTraversal145.postorderTraversal(treeNode));
    }
}
