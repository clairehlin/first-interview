package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractContainsDuplicateTest {

    @Test
    void can_find_duplicate() {
        // given
        int[] nums = {1, 2, 3, 1};

        // when
        boolean res = containsDuplicate().apply(nums);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_find_duplicate_with_long_array() {
        // given
        int[] nums = {1, 1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        // when
        boolean res = containsDuplicate().apply(nums);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_find_array_not_containing_duplicate() {
        // given
        int[] nums = {1, 2, 3, 4};

        // when
        boolean res = containsDuplicate().apply(nums);

        // then
        assertThat(res).isFalse();
    }

    abstract ContainsDuplicate containsDuplicate();
}