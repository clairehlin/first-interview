package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class BuySellTest {
    @Test
    void can_find_max_profit() {
        // given
        int[] prices = {7, 1, 5, 3, 6, 4};

        // when
        int max = new BuySell().maxProfit(prices);

        // then
        assertThat(max).isEqualTo(5);
    }

    @Test
    void fail_to_find_max_profit_with_decreasing_array() {
        // given
        int[] prices = {7, 6, 4, 3, 1};

        // when
        int max = new BuySell().maxProfit(prices);

        // then
        assertThat(max).isEqualTo(0);
    }

    @Test
    void can_find_max_profit_when_max_appearing_later_days() {
        // given
        int[] prices = {7, 2, 5, 3, 6, 1, 9};

        // when
        int max = new BuySell().maxProfit(prices);

        // then
        assertThat(max).isEqualTo(8);
    }

    @Test
    void can_find_max_profit2() {
        // given
        int[] prices = {7, 1, 5, 3, 6, 4};

        // when
        int max = new BuySell().maxProfit2(prices);

        // then
       assertThat(max).isEqualTo(5);
    }

    @Test
    void fail_to_find_max_profit_with_decreasing_array2() {
        // given
        int[] prices = {7, 6, 4, 3, 1};

        // when
        int max = new BuySell().maxProfit2(prices);

        // then
        assertThat(max).isEqualTo(0);
    }

    @Test
    void can_find_max_profit_when_max_appearing_later_days2() {
        // given
        int[] prices = {7, 2, 5, 3, 6, 1, 9};

        // when
        int max = new BuySell().maxProfit2(prices);

        // then
        assertThat(max).isEqualTo(8);
    }
}