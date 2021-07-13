package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateZeroesTest {

    @Test
    void can_duplicate_zeros() {
        // when
        int[] arr= {1, 0, 2, 3, 0, 4, 5, 0};

        // when
        new DuplicateZeroes().duplicateZeros(arr);

        assertThat(arr).isEqualTo(new int[]{1, 0, 0, 2, 3, 0, 0, 4});
    }

    @Test
    void cannot_duplicate_zeros_if_no_zero_input() {
        // when
        int[] arr= {1, 2, 3};

        // when
        new DuplicateZeroes().duplicateZeros(arr);

        assertThat(arr).isEqualTo(new int[]{1, 2, 3,});
    }

    @Test
    void can_duplicate_zeros_with_all_input_being_zero() {
        // when
        int[] arr= {0, 0, 0};

        // when
        new DuplicateZeroes().duplicateZeros(arr);

        assertThat(arr).isEqualTo(new int[]{0, 0, 0});
    }

    @Test
    void can_duplicate_zeros_with_all_input_being_zero2() {
        // when
        int[] arr= {0,0,0,0,0,0,0};

        // when
        new DuplicateZeroes().duplicateZeros(arr);

        assertThat(arr).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0});
    }

}