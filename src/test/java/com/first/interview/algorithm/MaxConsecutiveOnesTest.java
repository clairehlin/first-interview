package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxConsecutiveOnesTest {

    @Test
    void can_find_max_consecutive_ones() {
        // given
        int[] nums = {1, 1, 0, 1, 1, 1};

        // when
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void can_find_max_consecutive_ones_with_staring_digit_zero() {
        // given
        int[] nums = {0, 1, 1, 0, 1, 1, 1};

        // when
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void can_find_max_consecutive_ones_starting_with_one_and_zero() {
        // given
        int[] nums = {1, 0, 1, 1, 0, 1};

        // when
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);

        // then
        assertThat(result).isEqualTo(2);
    }
}