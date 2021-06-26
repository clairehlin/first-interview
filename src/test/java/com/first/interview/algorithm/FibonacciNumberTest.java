package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

    @Test
    void can_calculate_fibonacci_number() {
        // given
        int n = 4;

        // when
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        long res = fibonacciNumber.fib(n);

        // then
        assertThat(res).isEqualTo(3);
    }

    @Test
    void can_calculate_fibonacci_number_with_input_0() {
        // given
        int n = 0;

        // when
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        long res = fibonacciNumber.fib(n);

        // then
        assertThat(res).isEqualTo(0);
    }

    @Test
    void can_calculate_fibonacci_number2() {
        // given
        int n = 100;

        // when
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        long res = fibonacciNumber.fib(n);

        // then
        assertThat(res).isEqualTo(3);
    }
}