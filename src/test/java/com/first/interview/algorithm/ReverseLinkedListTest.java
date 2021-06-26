package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        // given
        ListNode head = new ListNode(1);

        ListNode node2 = new ListNode(2);
        head.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = null;


        // when
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverseList(head);

        // then
        assertThat(result.val).isEqualTo(5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}