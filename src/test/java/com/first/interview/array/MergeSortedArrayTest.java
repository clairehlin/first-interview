package com.first.interview.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MergeSortedArrayTest {

    @Test
    void can_merge_two_sorted_array() {
        // given
        int[] arr1 = {11, 7, 5, 1};
        int[] arr2 = {9, 17, 7, 8, 4, 5};

        // when
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        // then
        assertThat(mergeSortedArray.merge(arr1, arr2)).containsExactly(1, 4, 5, 5, 7, 7, 8, 9, 11, 17);
    }

    @Test
    void can_merge_with_one_empty_array() {
        // given
        int[] arr1 = {};
        int[] arr2 = {9, 17, 7, 8, 4, 5};

        // when
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        // then
        assertThat(mergeSortedArray.merge(arr1, arr2)).containsExactly(4, 5, 7, 8, 9, 17);
    }

    @Test
    void can_merge_two_empty_array() {
        // given
        int[] arr1= {};
        int[] arr2= {};

        // when
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        // then
        assertThat(mergeSortedArray.merge(arr1, arr2)).containsExactly();
    }

    @Test
    void fail_to_merge_null_array() {
        // given
        int[] arr1 = null;
        int[] arr2 = {1, 3, 5};

        // when
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        // then
        assertThatCode(() -> mergeSortedArray.merge(arr1, arr2)).isInstanceOf(NullPointerException.class);
    }
}