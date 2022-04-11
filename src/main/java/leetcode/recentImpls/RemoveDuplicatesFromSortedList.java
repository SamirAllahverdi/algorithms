package leetcode.recentImpls;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

//    /**
//     * https://leetcode.com/problems/remove-duplicates-from-sorted-list
//     */
//    public static void main(String[] args) {
//        ListNode head = fillLinkedList();
//        printLinkedList(deleteDuplicates(head));
//    }

    private static void printLinkedList(ListNode head) {

        StringBuilder builder = new StringBuilder();
        ListNode curr = head;
        while (curr != null){
            builder.append(curr.val).append(" ");
            curr = curr.next;
        }

        System.out.println(builder);
    }

    private static ListNode fillLinkedList() {
        ListNode head = new ListNode(1);

        ListNode curr = head;
        List<Integer> testInputList = Arrays.asList(1, 1, 2,3,4,5,5,5,6);

        for (Integer integer : testInputList) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }

        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;
        while (list != null && list.next != null) {
            if (list.val == list.next.val)
                list.next = list.next.next;
            else
                list = list.next;
        }
        return head;
    }


}
