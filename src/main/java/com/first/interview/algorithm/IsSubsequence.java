package com.first.interview.algorithm;

import java.util.Stack;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of
"abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */
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
