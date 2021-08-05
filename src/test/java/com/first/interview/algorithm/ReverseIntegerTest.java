package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    @Test
    void can_reverse_a_string() {
        // given
        int x = 123;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(321);
    }

    @Test
    void can_reverse_a_string_with_negative_number() {
        // given
        int x = -123;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(-321);
    }

    @Test
    void can_reverse_a_string_with_number_120() {
        // given
        int x = 120;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(21);
    }

    @Test
    void can_reverse_a_string_with_number_0() {
        // given
        int x = 0;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(0);
    }

    @Test
    void can_reverse_a_string_with_number_10() {
        // given
        int x = 10;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(1);
    }

    @Test
    void can_reverse_a_string_with_number_random() {
        // given
        int x = 12732185;

        // when
        ReverseInteger reverseInteger = new ReverseInteger();

        // then
        assertThat(reverseInteger.reverse(x)).isEqualTo(58123721);
    }
}