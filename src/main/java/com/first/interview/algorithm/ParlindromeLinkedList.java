package com.first.interview.algorithm;
/*
https://leetcode.com/problems/palindrome-linked-list/
create an Interger array list
iterate linked list and fill up the array list

create two pointers, one points to the head of the array list, the other points to the tail
if head value is not equal to the tail value, return false
 */
import java.util.ArrayList;
import java.util.List;

public class ParlindromeLinkedList {
    public boolean isParlindrome(Node node) {
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (list.get(i) != list.get(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
