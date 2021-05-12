package com.first.interview.brackets;

import java.util.Stack;

public class StackCheckBalanceAllBrackets implements CheckBalance {
    private static final String OPENING = "([{";
    private static final String CLOSING = ")]}";

    @Override
    public boolean apply(String input) {
        char[] chars = input.toCharArray();

        Stack<Character> openBrackets = new Stack<>();

        for (char element : chars) {
            if (OPENING.indexOf(element) >= 0) { //if the element being processed is an opening bracket, ie (, [, or {
                openBrackets.push(element);
            } else if (CLOSING.indexOf(element) >= 0) { //if the element being processed is an closing bracket, ie ), ], or }
                if (openBrackets.isEmpty() ||
                        OPENING.indexOf(openBrackets.peek()) != CLOSING.indexOf(element)) { // if the closing and opening are of the same type
                    return false;
                } else {
                    openBrackets.pop();
                }
            } else {
                throw new IllegalArgumentException("can only operate on parenthesis characters '(' ')' but got: " + element);
            }
        }

        return openBrackets.isEmpty();
    }
}
