package com.first.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubsequence2 {
    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        int tIndex = 0;

        while (tIndex < t.length()) {
            queue.add(t.charAt(tIndex++));
        }

        int sIndex = 0;
        while (sIndex < s.length()) {
            Character sElement = s.charAt(sIndex);

            while (!queue.isEmpty()) {
                if (sElement.equals(queue.poll())) {
                    sIndex++;
                    break;
                }
            }

            if (queue.isEmpty() && sIndex != s.length()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahlokc";

        IsSubsequence2 isSubsequence2 = new IsSubsequence2();
        boolean res = isSubsequence2.isSubsequence(s, t);
        System.out.println(res);
    }
}
