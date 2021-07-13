package com.first.interview.algorithm;

import java.util.Arrays;

public class BuySell {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    // brute force solution exceeded time limit
    public int maxProfit2(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                continue;
            } else {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] < prices[j]) {
                        int current = prices[j] - prices[i];
                        max = Math.max(max, current);
                    }
                }
            }
        }
        return max;
    }
}
