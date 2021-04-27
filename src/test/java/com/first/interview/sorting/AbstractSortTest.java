package com.first.interview.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

abstract class AbstractSortTest {
    protected abstract Sort sorting();

    @Test
    void can_sort_unsorted_array() {
        // given
        Integer[] values = {7, 1, 0, -1, 3, 8};

        // when
        Sort sort = sorting();
        sort.apply(values);


        // then
        assertThat(values).containsExactly(-1, 0, 1, 3, 7, 8);
    }

    @Test
    void should_fail_if_given_null_array() {
        // given
        Integer[] values = null;

        // when
        Sort sort = sorting();

        // then
        assertThatCode(() -> sort.apply(values))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("input cannot be null");
    }

    @Test
    void fail_null_element() {
        // given
        Integer[] values = {1, 3, null, 7};

        // when
        Sort sort = sorting();


        // then
        assertThatCode(() -> sort.apply(values)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void can_sort_empty_array() {
        // given
        Integer[] values = {};

        // when
        Sort sort = sorting();
        sort.apply(values);

        // then
        assertThat(values).containsExactly();
    }

    @Test
    void can_sort_a_single_element_array() {
        // given
        Integer[] values = {1};

        // when
        Sort sort = sorting();
        sort.apply(values);

        // then
        assertThat(values).containsExactly(1);
    }

    @Test
    void can_sort_two_elements_array() {
        // given
        Integer[] values = {7, 1};

        // when
        Sort sort = sorting();
        sort.apply(values);

        // then
        assertThat(values).containsExactly(1, 7);
    }

    @Test
    void can_sort_sorted_array() {
        // given
        Integer[] values = {1, 3, 7, 90};

        // when
        Sort sort = sorting();
        sort.apply(values);

        // then
        assertThat(values).containsExactly(1, 3, 7, 90);
    }
}