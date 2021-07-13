package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatsSortedArray2Test {

    @Test
    void remove() {
        // given
        int[] nums = {0, 0, 1, 2, 3};

        // when
        RemoveDuplicatsSortedArray2 removeDuplicatsSortedArray2 = new RemoveDuplicatsSortedArray2();
        int result = removeDuplicatsSortedArray2.remove(nums);

        // then
        assertThat(result).isEqualTo(4);

    }

    @Test
    void remove2() {
        // given
        int[] nums = {1, 1, 2, 2, 3, 3};

        // when
        RemoveDuplicatsSortedArray2 removeDuplicatsSortedArray2 = new RemoveDuplicatsSortedArray2();
        int result = removeDuplicatsSortedArray2.remove(nums);

        // then
        assertThat(result).isEqualTo(3);

    }

    @Test
    void remove3() {
        // given
        int[] nums = {1, 1, 1, 1, 1, 1};

        // when
        RemoveDuplicatsSortedArray2 removeDuplicatsSortedArray2 = new RemoveDuplicatsSortedArray2();
        int result = removeDuplicatsSortedArray2.remove(nums);

        // then
        assertThat(result).isEqualTo(1);

    }
}