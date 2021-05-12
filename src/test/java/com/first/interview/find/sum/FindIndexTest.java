package com.first.interview.find.sum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindIndexTest {

    @Test
    void can_find_two_index_numbers() {
        // given
        int[] input = {9, 5, 3, 7, 8, 1};

        // when
        FindIndex findIndex = new FindIndex();

        // then
        assertThat(findIndex.index(input, 17)).containsExactly(0, 4);
    }

    @Test
    void can_find_two_index_number_when_number_in_the_middle() {
        // given
        int[] input = {2, 12, 3, 7, 5, 8, 1};

        // when
        FindIndex findIndex = new FindIndex();

        // then
        assertThat(findIndex.index(input, 17)).containsExactly(1, 4);
    }

}