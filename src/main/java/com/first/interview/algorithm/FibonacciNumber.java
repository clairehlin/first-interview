package com.first.interview.algorithm;

/*
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

the current number is the previous two fibonacci numbers

leetcode 509
 */
class FibonacciNumber {
    public long fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public long fib2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long n0 = 0;
            long n1 = 1;
            int index = 2;

            while(index <= n) {
                long temp = n1 + n0;
                n0 = n1;
                n1 = temp;
                index++;
            }

            return n1;
        }
    }
}
