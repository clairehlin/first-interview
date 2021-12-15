package com.first.interview.algorithm;

public class MergedTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode merged = new ListNode();
        ListNode preHead = merged;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                merged.next = l1;
                merged = l1;
                l1 = l1.next;
            } else {
                merged.next = l2;
                merged = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            merged.next = l1;
        }

        if (l2 != null) {
            merged.next = l2;
        }

        return preHead.next;
    }
}
