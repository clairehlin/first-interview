package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    @Test
    void can_return_a_list_of_String() {
        // given
        int n = 3;

        // when
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.fizzBuzz(n);

        // then
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "Fizz"));
    }

    @Test
    void can_return_a_list_of_String_with_input_5() {
        // given
        int n = 5;

        // when
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.fizzBuzz(n);

        // then
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
    }

    @Test
    void can_return_a_list_of_String_with_input_15() {
        // given
        int n = 15;

        // when
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.fizzBuzz(n);

        // then
        assertThat(result).isEqualTo(Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
                "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        ));
    }

    @Test
    void can_return_a_list_of_String_with_second_implementation() {
        // given
        int n = 3;

        // when
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.fizzBuzz2(n);

        // then
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "Fizz"));
    }

    @Test
    void can_return_a_list_with_second_implementation_with_input_15() {
        // given
        int n = 15;

        // when
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> result = fizzBuzz.fizzBuzz2(n);

        // then
        assertThat(result).isEqualTo(Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
                "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        ));
    }
}