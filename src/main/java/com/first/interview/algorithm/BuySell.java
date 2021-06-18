package com.first.interview.algorithm;

import java.util.Arrays;

public class BuySell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuySell buySell = new BuySell();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buySell.maxProfit(prices));

    }
}
