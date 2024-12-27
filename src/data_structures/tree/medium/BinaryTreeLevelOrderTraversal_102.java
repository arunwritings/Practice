package data_structures.tree.medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
       if (root == null) {
           return result;
       }
       Deque<TreeNode> queue = new ArrayDeque<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           List<Integer> level = new ArrayList<>();
           int levelSize = queue.size();
           for (int i = 0; i < levelSize; i++) {
               TreeNode node = queue.poll();
               assert node != null;
               level.add(node.val);
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
           }
           result.add(level);
       }
       return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversal_102 solution = new BinaryTreeLevelOrderTraversal_102();
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
