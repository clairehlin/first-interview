package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class DivisorGame2 {
    private Map<Integer, Boolean> resultCache = new HashMap<>();

    public boolean divisorGame(int n) {
        return divisorGame(Turn.Alice, n);
    }

    private boolean divisorGame(Turn turn, int n) {
        System.out.println("player: " + turn + ", n: " + n);
        if (resultCache.containsKey(n)) {
            System.out.println("cache hit: " + n);
            return resultCache.get(n);
        }
        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                boolean otherPlayerWon = divisorGame(turn.other(), n - x);
                if (!otherPlayerWon) {
                    resultCache.put(n, true);
                    return true;
                }
            }
        }
        resultCache.put(n, false);
        return false;
    }

    enum Turn {
        Alice,
        Bob;

        public Turn other() {
            if (this == Alice) {
                return Bob;
            } else if (this == Bob) {
                return Alice;
            } else {
                throw new NullPointerException("cannot process null turns");
            }
        }
    }

}
