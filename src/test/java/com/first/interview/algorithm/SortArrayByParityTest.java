package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortArrayByParityTest {

    @Test
    void can_sort_Array_By_Parity() {
        // given
        int[] nums = new int[]{3, 1, 2, 4};

        // when
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParity2(nums);

        // then
        assertThat(res).isEqualTo(new int[]{4, 2, 1, 3});
    }

    @Test
    void can_sort_Array_By_Parity_with_all_even_numbers() {
        // given
        int[] nums = new int[]{8, 6, 2, 4};

        // when
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParity2(nums);

        // then
        assertThat(res).isEqualTo(new int[]{8, 6, 2, 4});
    }

    @Test
    void can_sort_Array_By_Parity_with_all_odd_numbers() {
        // given
        int[] nums = new int[]{3 , 1, 5, 9};

        // when
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParity2(nums);

        // then
        assertThat(res).isEqualTo(new int[]{3 , 1, 5, 9});
    }

    @Test
    void can_sort_Array_By_Parity_with_empty() {
        // given
        int[] nums = new int[]{};

        // when
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParity2(nums);

        // then
        assertThat(res).isEqualTo(new int[]{});
    }

    @Test
    void can_sort_Array_By_Parity_with_staggered_numbers() {
        // given
        int[] nums = new int[]{3, 8, 1, 2, 7, 4};

        // when
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParity2(nums);

        // then
        assertThat(res).isEqualTo(new int[]{4, 8, 2, 1, 7, 3});
    }
}