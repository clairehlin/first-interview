package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MajorityElement2Test {

    @Test
    void can_find_majority_element() {
        // given
        int[] nums = {3, 2, 3};

        // when
        int result = new MajorityElement2().apply(nums);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void can_find_majority_element_with_repeated_two_digits() {
        // given
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        // when
        int result = new MajorityElement2().apply(nums);

        // then
        assertThat(result).isEqualTo(2);
    }
}