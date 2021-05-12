package com.first.interview.remove.duplicates;

public class InitialRemoveDuplicates implements RemoveDuplicates {
    @Override
    public char[] apply(char[] chars) {
        if (chars.length == 0) {
            return chars;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                stringBuilder.append(chars[i]);
            }
        }
        stringBuilder.append(chars[chars.length - 1]);
        return stringBuilder.toString().toCharArray();
    }
}
