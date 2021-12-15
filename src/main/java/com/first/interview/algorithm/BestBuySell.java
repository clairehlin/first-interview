package com.first.interview.algorithm;

public class BestBuySell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 7, 3, 10, 2};
        BestBuySell bestBuySell = new BestBuySell();
        int res = bestBuySell.maxProfit(prices);
        System.out.println(res);
    }
}
