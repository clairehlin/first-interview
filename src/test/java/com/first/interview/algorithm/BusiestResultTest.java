package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BusiestResultTest {
    @Test
    void can_find_busiest_result() {
        // given
        int[][] results = new int[5][2];
        results[0][0] = 0;
        results[0][1] = 15;
        results[1][0] = 1;
        results[1][1] = 1;
        results[2][0] = 31;
        results[2][1] = 10;
        results[3][0] = 71;
        results[3][1] = 1;
        results[4][0] = 72;
        results[4][1] = 30;

        // when
        BusiestResult busiestResult = new BusiestResult();

        // then
        assertThat(busiestResult.findBusiest(results)).isEqualTo(31);
    }

    @Test
    void should_return_zero_for_empty() {
        // given
        int[][] results = new int[0][0];

        // when
        BusiestResult busiestResult = new BusiestResult();

        // then
        assertThat(busiestResult.findBusiest(results)).isEqualTo(0);
    }

    @Test
    void can_find_busiest_result_with_compact() {
        // given
        int[][] results = new int[5][2];
        results[0][0] = 0;
        results[0][1] = 15;
        results[1][0] = 1;
        results[1][1] = 1;
        results[2][0] = 7;
        results[2][1] = 10;
        results[3][0] = 9;
        results[3][1] = 1;
        results[4][0] = 11;
        results[4][1] = 30;

        // when
        BusiestResult busiestResult = new BusiestResult();

        // then
        assertThat(busiestResult.findBusiest(results)).isEqualTo(57);
    }

    @Test
    void can_find_busiest_result_for_sparse() {
        // given
        int[][] results = new int[5][2];
        results[0][0] = 0;
        results[0][1] = 15;
        results[1][0] = 35;
        results[1][1] = 1;
        results[2][0] = 70;
        results[2][1] = 10;
        results[3][0] = 103;
        results[3][1] = 1;
        results[4][0] = 150;
        results[4][1] = 30;

        // when
        BusiestResult busiestResult = new BusiestResult();

        // then
        assertThat(busiestResult.findBusiest(results)).isEqualTo(30);
    }

}