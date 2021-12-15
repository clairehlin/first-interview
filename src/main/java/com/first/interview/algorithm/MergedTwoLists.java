package com.first.interview.algorithm;

public class MergedTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        head1.next = new ListNode(2);
        head2.next = new ListNode(4);

        MergedTwoLists mergedTwoLists = new MergedTwoLists();
        ListNode res = mergedTwoLists.mergeTwoLists(head1, head2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
