package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Logger2 {
    private static Map<String, Integer> map;

    public Logger2() {
        this.map = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean res = false;
        if (map.containsKey(message)) {
            int currentTimeStamp = map.get(message);
            if (timestamp - currentTimeStamp >= 10) {
                res = true;
                map.put(message, timestamp);
            } else {
                res = false;
            }
        } else {
            map.put(message, timestamp);
            res = true;
        }
        return res;
    }

}
