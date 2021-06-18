package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (map.get(stack.pop()) != chars[i]) {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }
}
