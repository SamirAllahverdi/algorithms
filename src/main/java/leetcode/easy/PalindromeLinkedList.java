package leetcode.easy;

public class PalindromeLinkedList {

    /**
     * -  https://leetcode.com/problems/palindrome-linked-list
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public boolean isPalindrome(ListNode head) {

        ListNode current = head;

        StringBuilder builder = new StringBuilder();

        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }

        String traverse = builder.toString();
        return builder.reverse().toString().equals(traverse);
    }

}
