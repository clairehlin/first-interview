package com.first.interview.algorithm;

import org.apache.commons.lang3.Validate;

public class LinkedListLength {
    int isLengthEvenOrOdd(Node node) {
        Validate.notNull(node, "input element cannot be null");
        int length = 0;

        while (node.next != null) {
            length++;
            node = node.next;
        }

        if (length % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
