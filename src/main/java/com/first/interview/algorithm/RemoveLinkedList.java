package com.first.interview.algorithm;

public class RemoveLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        // handle the head equals val case, because we have no previous
        while (head != null && head.val == val) {
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        if (head != null) { // if all elements equal to val , then head would be null at this point
            // handle the rest of the linked list as we have previous
            ListNode current = head.next;
            ListNode previous = head;
            while (current != null) {
                if (current.val == val) {
                    previous.next = current.next;
                    current.next = null;
                    current = previous.next;
                } else {
                    previous = previous.next;
                    current = current.next;
                }
            }
        }

        return head;
    }

    static public class ListNode {
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
}
