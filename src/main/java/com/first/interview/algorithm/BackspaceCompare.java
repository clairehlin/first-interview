package com.first.interview.algorithm;
/*
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
 */
import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        s1 = buildStack(s1, s);
        s2 = buildStack(s2, t);

        return s1.equals(s2);
    }

    private Stack<Character> buildStack(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (s.charAt(i) == '#' && stack.isEmpty()) {
                continue;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }
}
