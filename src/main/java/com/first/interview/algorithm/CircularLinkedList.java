package com.first.interview.algorithm;

import java.util.LinkedList;

public class CircularLinkedList {
    public boolean containsCircular(Node root) {
        Node fast = root.next.next;
        Node slow = root.next;

        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
