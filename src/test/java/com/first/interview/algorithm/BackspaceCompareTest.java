package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BackspaceCompareTest {

    @Test
    void can_compare_two_strings() {
        // given
        String s = "ab#c";
        String t = "ad#c";

        // when
        boolean result = new BackspaceCompare().backspaceCompare(s, t);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_compare_two_strings_with_different_order_in_characters() {
        // given
        String s = "ab##";
        String t = "c#d#";

        // when
        boolean result = new BackspaceCompare().backspaceCompare(s, t);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_compare_two_strings_with_different_order() {
        // given
        String s = "a##c";
        String t = "#a#c";

        // when
        boolean result = new BackspaceCompare().backspaceCompare(s, t);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_compare_two_strings_with_different_length_of_strings() {
        // given
        String s = "a#c";
        String t = "b";

        // when
        boolean result = new BackspaceCompare().backspaceCompare(s, t);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void can_compare_two_strings_with_different_length_of_strings2() {
        // given
        String s = "y#fo##f";
        String t = "y#f#o##f";

        // when
        boolean result = new BackspaceCompare().backspaceCompare(s, t);

        // then
        assertThat(result).isTrue();
    }

}