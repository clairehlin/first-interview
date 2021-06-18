package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunningSumTest {
    @Test
    void can_sum_running_array() {
        // given
        int[] nums = new int[]{1, 2, 3, 4};

        // when
        RunningSum input = new RunningSum();

        // then
        assertThat(input.runningSum(nums)).isEqualTo(new int[]{1, 3, 6, 10});
    }

    @Test
    void can_sum_running_array_with_all_input_being_the_same_number() {
        // given
        int[] nums = new int[]{1, 1, 1, 1};

        // when
        RunningSum input = new RunningSum();

        // then
        assertThat(input.runningSum(nums)).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    void can_sum_running_array_with_random_numbers() {
        // given
        int[] nums = new int[]{3, 1, 2, 10, 1};

        // when
        RunningSum input = new RunningSum();

        // then
        assertThat(input.runningSum(nums)).isEqualTo(new int[]{3, 4, 6, 16, 17});
    }

}