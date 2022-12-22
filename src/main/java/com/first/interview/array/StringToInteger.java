package com.first.interview.array;

/*
https://leetcode.com/problems/string-to-integer-atoi/
follow the rule one by one
first check string length, if it equals to zero, return 0

then assign a pointer, if it is space character, keeps moving pointer by 1

then check + or - sign, assign a variable value to be 1 or -1 accordingly.

then iterate the String, only check number within '0' or '9'
also handle out of range number to be either Max Integer or Min integer

 */
public class StringToInteger {

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int pointer = 0;
        int digit = 0;
        int res = 0;

        while (pointer < s.length() && s.charAt(pointer) == ' ') {
            pointer++;
        }

        if (pointer < s.length() && s.charAt(pointer) == '-') {
            sign = -1;
            pointer++;
        } else if (pointer < s.length() && s.charAt(pointer) == '+') {
            pointer++;
        }

        while (pointer < s.length() && s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
            digit = s.charAt(pointer) - '0';

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(pointer) - '0' > 7))
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }

            res = 10 * res + digit;
            pointer++;

        }

        return sign * res;

    }
}
