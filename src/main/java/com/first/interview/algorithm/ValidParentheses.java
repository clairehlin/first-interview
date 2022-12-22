package com.first.interview.algorithm;
/*
https://leetcode.com/problems/valid-parentheses/

create a Map, key - value pair, left parentheses as keys, right parentheses as values
iterate input string one character by one character
create a stack
if map contains character as key, push the character to the stack
if map does not contain the character as key, pop one character out from the stack,
based on the popped character, look up in map, if the corresponding value of the character does not match popped character, return false

return result of stack is empty or not
 */
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
