package leetcode.recentImpls;

public class MinimumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree
     */
//    public static void main(String[] args) {
//
//    }


    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
