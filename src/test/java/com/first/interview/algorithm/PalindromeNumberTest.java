package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void can_identify_parlindrome_number() {
        // given
        int x = 121;

        // when
        boolean result = new PalindromeNumber().isParlinDrome(x);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_identify_parlindrome_number_with_zero_being_in_the_middle() {
        // given
        int x = 103;

        // when
        boolean result = new PalindromeNumber().isParlinDrome(x);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void can_identify_parlindrome_number_with_single_digit_input() {
        // given
        int x = 1;

        // when
        boolean result = new PalindromeNumber().isParlinDrome(x);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_identify_parlindrome_number_with_input_being_10() {
        // given
        int x = 10;

        // when
        boolean result = new PalindromeNumber().isParlinDrome(x);

        // then
        assertThat(result).isFalse();
    }
}