package com.first.interview.array;

public class ReverseWithSwap implements Reverse{
    @Override
    public String apply(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0, end = input.length() - 1; i < input.length() / 2; i++, end--) {
            char temp = chars[end];
            chars[end] = chars[i];
            chars[i] = temp;
        }

        return new String(chars);
    }
}
