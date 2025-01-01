package data_structures.tree.easy;

import java.util.*;

public class BinaryTreeInorderTraversal_94 {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      /*INPUT: A
      *      B   C
      *
      *OUTPUT: B A C
      *Explanation: The Inorder Traversal visits the nodes in the following order: Left, Root, Right.
      *Therefore, we visit the left node B, then the root node A and lastly the right node C.
      **/
    //Iterative method
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            answer.add(root.val);
            root = root.right;
        }
        return answer;
    }*/

    //Recursive method
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal94 = new BinaryTreeInorderTraversal_94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(binaryTreeInorderTraversal94.inorderTraversal(root));
    }
}
