package data_structures.tree.hard;

public class BinaryTreeMaximumPathSum_124 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxSum;
    }

    private int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);

        int currentSum = root.val + left + right;
        maxSum = Math.max(maxSum, currentSum);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum_124 binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum_124();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }
}
