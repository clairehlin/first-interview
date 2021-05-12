package com.first.interview.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackReverseTest {

    @Test
    void can_reverse_value_of_an_integer() {
        // given
        int input = 78923;

        // when
        StackReverse stackReverse = new StackReverse();

        // then
        assertThat(stackReverse.apply(input)).isEqualTo(32987);
    }


    @Test
    void can_reverse_value_of_a_single_digit() {
        // given
        int input = 1;

        // when
        StackReverse stackReverse = new StackReverse();

        // then
        assertThat(stackReverse.apply(input)).isEqualTo(1);
    }

    @Test
    void can_reverse_value_of_three_digits() {
        // given
        int input = 327;

        // when
        StackReverse stackReverse = new StackReverse();

        // then
        assertThat(stackReverse.apply(input)).isEqualTo(723);
    }

    @Test
    void can_reverse_value_of_four_digits() {
        // given
        int input = 1234;

        // when
        StackReverse stackReverse = new StackReverse();

        // then
        assertThat(stackReverse.apply(input)).isEqualTo(4321);
    }
}