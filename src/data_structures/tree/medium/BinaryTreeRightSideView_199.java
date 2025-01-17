package data_structures.tree.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    
    public static class TreeNode {

          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int val) { this.val = val; }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        BinaryTreeRightSideView_199 binaryTreeRightSideView199 = new BinaryTreeRightSideView_199();
        System.out.println(binaryTreeRightSideView199.rightSideView(root));
    }
}
