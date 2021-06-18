package com.first.interview.array;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

abstract class AbstractFindDuplicateIntTest {

    @Test
    void cannot_find_duplicate_in_an_array_with_a_single_element() {
        // given
        int[] input = {0};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThatCode(() -> findDuplicate.apply(input)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void can_find_duplicate_in_an_array() {
        // given
        int[] input = {1, 1};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isEqualTo(1);
    }

    @Test
    void can_find_duplicate_in_an_array_with_three_elements() {
        // given
        int[] input = {2, 1, 2};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isEqualTo(2);
    }

    @Test
    void can_find_duplicate_in_an_array_with_the_same_value_of_elements() {
        // given
        int[] input = {3, 3, 3, 3};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isEqualTo(3);
    }

    @Test
    void can_find_duplicate_in_an_array_with_two_sets_of_duplicate() {
        // given
        int[] input = {3, 1, 1, 3};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isIn(3, 1);
    }

    @Test
    void can_find_duplicate_in_an_array_with_5_elements() {
        // given
        int[] input = {1, 2, 3, 2, 4};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isEqualTo(2);
    }

    @Test
    void can_find_duplicate_in_an_array_with_5_elements_big() {
        // given
        int[] input = IntStream.range(0, 10000).toArray();
        input[9998] = 9999;

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThat(findDuplicate.apply(input)).isEqualTo(9999);
    }

    @Test
    void failed_to_find_duplicate_in_an_empty_array() {
        // given
        int[] input = {};

        // when
        FindDuplicate findDuplicate = getFindDuplicateInt();

        // then
        assertThatCode(() -> findDuplicate.apply(input)).isInstanceOf(NoSuchElementException.class);
    }

    abstract FindDuplicate getFindDuplicateInt();
}