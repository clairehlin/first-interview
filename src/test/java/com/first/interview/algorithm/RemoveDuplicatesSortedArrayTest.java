package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesSortedArrayTest {

    @Test
    void can_remove_duplicates_from_sorted_array() {
        // given
        int[] nums = {1, 1, 2};

        // when
        int result = new RemoveDuplicatesSortedArray().removeDuplicates(nums);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void can_remove_duplicates_from_sorted_long_array() {
        // given
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        // when
        int result = new RemoveDuplicatesSortedArray().removeDuplicates(nums);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void cannot_remove_duplicates_from_single_digit_array() {
        // given
        int[] nums = {0};

        // when
        int result = new RemoveDuplicatesSortedArray().removeDuplicates(nums);

        // then
        assertThat(result).isEqualTo(1);
    }
}