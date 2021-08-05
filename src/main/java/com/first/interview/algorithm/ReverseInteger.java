package com.first.interview.algorithm;

public class ReverseInteger {
    public int reverse(int x) {
       int input = Math.abs(x);
       int res = 0;

       while (input >= 10) {
           int remainder = input % 10;
           res = res * 10 + remainder;
           input = input / 10;
       }

       res = res * 10 + input;

      if (x < 0) {
           return -res;
       } else {
           return res;
       }
    }
}
