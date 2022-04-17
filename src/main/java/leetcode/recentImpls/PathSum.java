package leetcode.recentImpls;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * https://leetcode.com/problems/path-sum
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (isLeafNode(root)) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
