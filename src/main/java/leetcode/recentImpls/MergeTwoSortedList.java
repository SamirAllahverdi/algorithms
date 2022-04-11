package leetcode.recentImpls;

public class MergeTwoSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
     */
//    public static void main(String[] args) {
//
//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode();
//        l2.next = new ListNode(2);
//
//        System.out.println(mergeTwoLists(l1, l2));
//    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
