package com.first.interview.brackets;

import com.sun.jdi.StackFrame;

import java.util.Stack;

public class StackCheckBalanceParenthesis implements CheckBalance {
    @Override
    public boolean apply(String input) {
        char[] chars = input.toCharArray();

        Stack<Character> parenthesis = new Stack<>();

        for (char element : chars) {
            if (element == '(') {
                parenthesis.push(element);
            } else if (element == ')') {
                if (parenthesis.isEmpty()) {
                    return false;
                } else {
                    parenthesis.pop();
                }
            } else {
                throw new IllegalArgumentException("can only operate on parenthesis characters '(' ')' but got: " + element);
            }
        }

        return parenthesis.isEmpty();
    }
}
