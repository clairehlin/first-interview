package com.first.interview.algorithm;

public class ReplaceQuestionMark2 {
    private static final char[] letters = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'
    };

    public String modifyString2(String s) {
        char[] input = s.toCharArray();

        if (input.length == 1 && input[0] == '?') {
            input[0] = letters[0];
        } else if (input.length == 1) {
            return s;
        }

        for (int i = 0; i < input.length; i++) {
            if (i == 0 && input[i] == '?') {
                input[i] = requestChar(input[i + 1]);
            } else if (i == input.length - 1 && input[i] == '?') {
                input[i] = requestChar(input[i - 1]);
            } else if (input[i] == '?') {
                input[i] = requestChar(input[i - 1], input[i + 1]);
            }
        }
        return String.valueOf(input);
    }

    // circular solution. Treats array as circular structure
    // the element before the first is the last element in the array
    // the element after the last is the first element in the array
    public String modifyString(String s) {
        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '?') {
                input[i] = requestChar(
                        before(i, input),
                        after(i, input)
                );
            }
        }
        return String.valueOf(input);
    }

    private char after(int i, char[] input) {
        return i == input.length - 1 ? input[0] : input[i + 1];
    }

    private char before(int i, char[] input) {
        return i == 0 ? input[input.length - 1] : input[i - 1];
    }

    /*
    private char requestChar(char before, char after) {
        for (char letter : letters) {
            if (letter != before && letter != after) {
                return letter;
            }
        }
        throw new IllegalStateException("the program should have never been here");
    }

     */

    /*private char requestChar(char c) {
        for (char letter : letters) {
            if (letter != c) {
                return letter;
            }
        }
        throw new IllegalStateException("the program should have never been here");
    }

     */

    private char requestChar(char... cs) {
        for (char letter : letters) {
            if (notIn(letter, cs)) {
                return letter;
            }
        }
        throw new IllegalStateException("the program should have never been here");
    }

    private boolean notIn(char letter, char[] cs) {
        for (char c : cs) {
            if (letter == c) {
                return false;
            }
        }
        return true;
    }
}
