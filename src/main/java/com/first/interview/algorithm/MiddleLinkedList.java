package com.first.interview.algorithm;

public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 1;

        while (head.next != null) {
            head = head.next;
            count++;
        }

        int pos = count / 2;

        while (pos > 0) {
            temp = temp.next;
            pos--;
        }

        return temp;
    }
}
