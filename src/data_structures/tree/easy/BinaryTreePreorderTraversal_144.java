package data_structures.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {

    static class TreeNode {
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
    * OUTPUT:ABC
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preOrderHelper(root, answer);
        return answer;
    }

    private void preOrderHelper(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        preOrderHelper(root.left, answer);
        preOrderHelper(root.right, answer);
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal_144 binaryTreePreorderTraversal144 = new BinaryTreePreorderTraversal_144();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        System.out.println(binaryTreePreorderTraversal144.preorderTraversal(treeNode));
    }
}
