package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveZeroesTest {
    @Test
    void can_move_zero() {
        // given
        int[] nums = {0, 1, 0, 3, 12};

        // when
        new MoveZeroes().apply(nums);

        // then
        assertThat(nums).isEqualTo(new int[]{1, 3, 12, 0, 0});
    }

    @Test
    void can_move_zero_with_only_one_input_zero() {
        // given
        int[] nums = {0};

        // when
        new MoveZeroes().apply(nums);

        // then
        assertThat(nums).isEqualTo(new int[]{0});
    }

    @Test
    void can_move_zero_if_input_being_empty() {
        // given
        int[] nums = {};

        // when
        new MoveZeroes().apply(nums);

        // then
        assertThat(nums).isEqualTo(new int[]{});
    }

    @Test
    void can_move_zero_with_order_zero_zero_one() {
        // given
        int[] nums = {0, 0, 1};

        // when
        new MoveZeroes().apply(nums);

        // then
        assertThat(nums).isEqualTo(new int[]{1, 0, 0});
    }

    @Test
    void can_move_zero_with_many_zeros() {
        // given
        int[] nums = {0, 0, 0, 0, 1};

        // when
        new MoveZeroes().apply(nums);

        // then
        assertThat(nums).isEqualTo(new int[]{1, 0, 0, 0, 0});
    }
}