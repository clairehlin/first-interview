package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
