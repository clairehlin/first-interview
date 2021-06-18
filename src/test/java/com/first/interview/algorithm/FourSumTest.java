package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {
    @Test
    void can_sort_array() {
        // given
        int[] unsorted = {9, 5, 3, 5, 9};

        // when
        Arrays.sort(unsorted);

        //then
        int[] expected = {3, 5, 5, 9, 9};
        assertThatCode(() -> Arrays.sort(unsorted)).isEqualTo(expected);

    }

}