package com.first.interview.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CheckCircularLinkedList {
    boolean check(Node node) {
        Set<Node> sets = new HashSet<>();

        while (node != null) {
            if (!sets.contains(node)) {
                sets.add(node);
                node = node.next;
            } else {
                return true;
            }
        }
        return false;
    }

    Node reverse(Node node) {
        Stack<Node> stack = new Stack<>();

        while(node != null) {
            stack.push(node);
            node = node.next;
        }

        Node head = stack.peek();
        Node curr = null;

        while(!stack.isEmpty()){
            curr = stack.pop();
            Node temp = null;
            if (!stack.isEmpty()) {
                temp = stack.peek();
            }
            curr.next = temp;
        }

        return head;
    }
}
