package com.first.interview.numbers;

import java.util.Stack;

public class StackReverse implements Reverse {
    // reverse an int value, 1234 -> 4321
    // 1234 % 10 , remainder is 4 -> push it into stack
    // pop it out from the stack, value = 10 the power of 0 -> value X pop() = last digit
    // pop it out from the stack, value = 10 the power of 1 -> value X pop() + value = new value = last two digits

    @Override
    public int apply(int input) {
        Stack<Integer> stack = outputToStack(input);
        int reversedValue = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int power = (int) Math.pow(10, i);
            reversedValue = power * stack.pop() + reversedValue;
        }
        return reversedValue;
    }

    private Stack<Integer> outputToStack(int input) {
        Stack<Integer> outputStack = new Stack<>();

        while (input % 10 >= 1) {
            outputStack.push(input % 10);
            input = input / 10;
        }
        return outputStack;
    }
}
