package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class kthMissingPositiveNumberTest {

    @Test
    void findKthPositive() {
        // given
        int[] arr = {2, 3, 4, 7, 11};

        // when
        int result = new MissingPositiveNumber().findKthPositive(arr, 5);

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void find_missing_number_when_k_being_greater_than_input_length() {
        // given
        int[] arr = {1, 2, 3, 4};

        // when
        int result = new MissingPositiveNumber().findKthPositive(arr, 2);

        // then
        assertThat(result).isEqualTo(6);
    }
}