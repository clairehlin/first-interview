package com.first.interview.array;

import java.util.Stack;

public class ReverseString implements Reverse {
    @Override
    public String apply(String input) {
        Stack<Character> stack = outputToStack(input);
        char[] chars = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    private Stack<Character> outputToStack(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            stack.push(chars[i]);
        }
        return stack;
    }
}
