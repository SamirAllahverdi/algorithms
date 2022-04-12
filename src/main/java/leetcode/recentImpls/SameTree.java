package leetcode.recentImpls;

public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * https://leetcode.com/problems/same-tree
     */
//    public static void main(String[] args) {
//
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }


}
