package com.first.interview.algorithm;

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x/10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
