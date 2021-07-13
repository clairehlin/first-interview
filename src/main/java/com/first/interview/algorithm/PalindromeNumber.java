package com.first.interview.algorithm;

public class PalindromeNumber {
    public boolean isParlinDrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int input = x;
        int reversedNum = 0;

        while (input >= 10) {
            int remainder = input % 10;
            reversedNum = (reversedNum + remainder) * 10;
            input = input / 10;
        }

        reversedNum = reversedNum + input;

        return x == reversedNum;
    }
}
