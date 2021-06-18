package com.first.interview.algorithm;

public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'A') {
                count++;
            }
        }

        return count < 2 && s.indexOf("LLL") < 0;

    }
}
