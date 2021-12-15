package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ParlindromeLinkedList2 {
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
