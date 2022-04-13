package leetcode.recentImpls;

import java.util.Stack;

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * https://leetcode.com/problems/symmetric-tree
     */
//    public static void main(String[] args) {
//
//    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            stack.push(n1.left);
            stack.push(n2.right);

            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
