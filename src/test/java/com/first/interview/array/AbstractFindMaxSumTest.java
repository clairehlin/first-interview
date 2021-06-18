package com.first.interview.array;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractFindMaxSumTest {

    @Test
    void can_find_maximum_sum_from_subArray_single_value() {
        // given
        int[] input = {-1, 1, -2, 17, -3};

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(17);
    }

    @Test
    void can_find_maximum_sum_from_subArray() {
        // given
        int[] input = {-1, 4, 2, 1, -3};

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(7);
    }

    @Test
    void can_find_maximum_sum_from_long_subArray() {
        // given
        int[] input = {-1, 8, -1, 18, -7};

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(25);
    }

    @Test
    void can_find_maximum_sum_from_large_subArray() {
        // given
        int[] input = IntStream.range(0, 1000).toArray();

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(499500);
    }

    @Test
    void can_find_maximum_sum_from_eight_int_length_subArray() {
        // given
        int[] input = {-1, 2, 7, -3, 8, -1, 0, 1};

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(14);
    }

    @Test
    void can_find_maximum_sum_from_single_digit_subArray() {
        // given
        int[] input = {-1};

        // when
        FindMaxSum max = findMaxSum();

        // then
        assertThat(max.apply(input)).isEqualTo(-1);
    }

    protected abstract FindMaxSum findMaxSum();
}