package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractValidPalindromeIITest {
    @Test
    void can_identify_if_a_string_contains_single_char() {
        // given
        String s = "a";

        // when
        boolean res = validPalindromeII().apply(s);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_identify_if_a_string_being_palindrome() {
        // given
        String s = "aba";

        // when
        boolean res = validPalindromeII().apply(s);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_identify_if_string_with_even_number_of_chars_being_palindrome() {
        // given
        String s = "abca";

        // when
        boolean res = validPalindromeII().apply(s);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_identify_if_a_string_contains_odd_number_of_chars_being_palindrome() {
        // given
        String s = "abc";

        // when
        boolean res = validPalindromeII().apply(s);

        // then
        assertThat(res).isFalse();
    }

    @Test
    void can_identify_if_a_string_containing_one_diff_character() {
        // given
        String s = "deeee";

        // when
        boolean res = validPalindromeII().apply(s);

        // then
        assertThat(res).isTrue();
    }

    abstract ValidPalindromeII validPalindromeII();

}