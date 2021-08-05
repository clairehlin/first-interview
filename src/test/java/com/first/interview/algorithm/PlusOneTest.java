package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void can_plus_one_on_an_array_of_int() {
        // given
        int[] digits = {1, 2, 3};

        // when
        int[] res = new PlusOne().plusOne(digits);

        // then
        assertThat(res).isEqualTo(new int[] {1, 2, 4});
    }

    @Test
    void can_plus_one_on_an_array_of_integer_carry_forward_one() {
        // given
        int[] digits = {1, 2, 9};

        // when
        int[] res = new PlusOne().plusOne(digits);

        // then
        assertThat(res).isEqualTo(new int[] {1, 3, 0});
    }

    @Test
    void can_plus_one_on_an_array_of_integer2() {
        // given
        int[] digits = {4, 3, 2, 1};

        // when
        int[] res = new PlusOne().plusOne(digits);

        // then
        assertThat(res).isEqualTo(new int[] {4, 3, 2, 2});
    }

    @Test
    void can_plus_one_on_an_array_of_all_9() {
        // given
        int[] digits = {9, 9, 9};

        // when
        int[] res = new PlusOne().plusOne(digits);

        // then
        assertThat(res).isEqualTo(new int[] {1, 0, 0, 0});
    }
}