package com.first.interview.algorithm;

import java.util.HashSet;
import java.util.Set;

public class DetectLinkedList {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (set.contains(current)) {
                return true;
            } else {
                set.add(current);
                current = current.next;
            }
        }

        return false;
    }
}
