package com.first.interview.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractReverseTest {
    protected abstract Reverse reverse();

    @Test
    void can_reverse_a_string() {
        // given
        String input = "hello";

        // when
        Reverse reverse = reverse();

        // then
        assertThat(reverse.apply(input)).isEqualTo("olleh");
    }

    @Test
    void can_reverse_a_string_with_space_in_the_middle() {
        // given
        String input = "hello world";

        // when
        Reverse reverse = reverse();

        // then
        assertThat(reverse.apply(input)).isEqualTo("dlrow olleh");
    }

    @Test
    //TODO
    void fail_on_null_input() {
        throw new UnsupportedOperationException("remember to implement it");
    }
}
