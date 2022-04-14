package leetcode.recentImpls;

public class MaximumDepthForSearch {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

//    public static void main(String[] args) {
//
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }


    public int maxDepth(TreeNode root, int i) {
        if (root == null) return i;
        return Math.max(maxDepth(root.left, i + 1), maxDepth(root.right, i + 1));
    }
}


