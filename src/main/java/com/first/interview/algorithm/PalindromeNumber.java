package com.first.interview.algorithm;

public class PalindromeNumber {
    public boolean isParlinDrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int reversedNum = 0;
        int input = x;
        while (input >= 10) {
            reversedNum = reversedNum * 10 + input % 10;
            input = input / 10;
        }

        reversedNum = reversedNum * 10 + input;

        return reversedNum == x;
    }
}
