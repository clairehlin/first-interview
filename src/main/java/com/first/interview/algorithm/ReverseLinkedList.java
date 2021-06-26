package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode result = temp;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.val = list.get(i);
            temp = temp.next;
        }

        return result;
    }
}
