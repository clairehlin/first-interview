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

}