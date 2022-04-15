package leetcode.recentImpls;

public class ConvertSortedArrayToBinarySearchTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
     */
//    public static void main(String[] args) {
//
//    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }


}
