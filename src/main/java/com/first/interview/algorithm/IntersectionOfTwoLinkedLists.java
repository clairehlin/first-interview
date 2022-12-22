package com.first.interview.algorithm;

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/

create a set
iterate linked list A , add elements to the set
iterate linked list B, check if the element exists in set, if yes, found intersected node
if not, keep moving nodes in B

if nothing is found, return null
 */
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
