package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> strPool = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (strPool.containsKey(message)) {
            int currentTimestamp = strPool.get(message);
            if (timestamp >= currentTimestamp) {
                currentTimestamp = timestamp + 10;
                strPool.put(message, currentTimestamp);
                return true;
            } else {
                return false;
            }
        } else {
            strPool.put(message, timestamp + 10);
            return true;
        }
    }
}
