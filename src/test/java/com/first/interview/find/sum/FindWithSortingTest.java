package com.first.interview.find.sum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FindWithSortingTest {

    @Test
    void can_find_two_index_numbers() {
        // given
        int[] input = {9, 5, 3, 7, 8, 1};

        // when
        FindWithSorting findIndex = new FindWithSorting();

        // then
        assertThat(findIndex.index(input, 17)).contains(0, 4);
    }
}