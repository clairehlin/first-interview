package com.first.interview.algorithm;
// leetcode 1576

public class ReplaceQuestionMark {
    private static final char[] letters = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'
    };

    public String modifyString(String s) {
        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (input.length == 1 && input[i] == '?') {
                int countLetters = 0;
                input[i] = letters[countLetters];
            } else if (input.length == 1) {
                return s;
            }

            if (input[i] == '?' && i != input.length - 1) {
                char post = input[i + 1];
                int countLetters = 0;

                if (i == 0) {
                    while (letters[countLetters] == post) {
                        countLetters++;
                    }
                } else {
                    char pre = input[i - 1];
                    while (letters[countLetters] == pre || letters[countLetters] == post) {
                        countLetters++;
                    }
                }
                input[i] = letters[countLetters];
            } else if (i == input.length - 1 && input[i] == '?') {
                char pre = input[i - 1];
                int countLetters = 0;
                while (letters[countLetters] == pre) {
                    countLetters++;
                }
                input[i] = letters[countLetters];
            }
        }
        return new String(input);
    }
}
