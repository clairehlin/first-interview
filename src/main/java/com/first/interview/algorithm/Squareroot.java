package com.first.interview.algorithm;

import java.util.NoSuchElementException;

public class Squareroot {
    int sqrt(int num) {
        int half = num / 2;

        while (half >= 0) {
            if (half * half <= num) {
                return half;
            } else{
                half--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int input = 36;
        Squareroot squareroot = new Squareroot();
        int res = squareroot.sqrt(input);
        System.out.println(res);
    }
}
