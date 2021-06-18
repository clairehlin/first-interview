package com.first.interview.algorithm;

public class EvenLinkedList {
    int isLengthEvenOrOdd(Node head) {
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        if (length % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private class Node {
        int value;
        Node next;
    }
}
