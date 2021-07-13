package com.first.interview.algorithm;

import java.util.Stack;

public class IsSubsequence {
    public boolean apply(String s, String t) {
        Stack<Character> stack = new Stack<>();
        char[] base = t.toCharArray();
        char[] sub = s.toCharArray();


        for (int i = base.length - 1; i >= 0; i--) {
            stack.push(base[i]);
        }

        for (int i = 0; i < sub.length; i++) {
            if (!find(sub[i], stack)) {
                return false;
            }
        }
        return true;
    }

    private boolean find(char c, Stack<Character> stack) {
        while (!stack.isEmpty()) {
            if (c == stack.pop()) {
                return true;
            }
        }
        return false;
    }
}
