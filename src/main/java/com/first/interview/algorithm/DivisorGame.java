package com.first.interview.algorithm;

public class DivisorGame {
    public boolean divisorGame(int n) {
       if (n == 1) {
           return true;
       }

       for (int steps = 1; steps < n; steps++) {
           if (!canMove(steps, n)) {
               return false;
           }
       }
       return true;
    }

    private boolean canMove(int movingSteps, int totalSteps) {
        int count = 0;
        for (int i = movingSteps; i < totalSteps; i++) {
            if (totalSteps % i == 0) {
                totalSteps = totalSteps - i;
                count++;
            }
        }

        return count % 2 != 0;
    }


}
