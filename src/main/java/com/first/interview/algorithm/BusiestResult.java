package com.first.interview.algorithm;

/*
timestamp, # of results
0, 15
1, 1
31, 10
71, 1
72, 30

find the busiest result during 30 minutes interval
at the 1st minute, total result is 16
at the 31 minute, total result is 11
at the 71st minute, total result is 1
at the 72 minute, total result is 31
 */
public class BusiestResult {

    int findBusiest(int[][] data) {
        int busiest = 0;

        for (int i = 0; i < data.length; i++) {
            int sum = data[i][1];
            busiest = Math.max(busiest, sum);

            for (int j = i + 1; j < data.length; j++) {
                if (data[j][0] - data[i][0] <= 30) {
                    sum = sum + data[j][1];
                    busiest = Math.max(busiest, sum);
                } else {
                    break;
                }
            }
        }
        return busiest;
    }
}
