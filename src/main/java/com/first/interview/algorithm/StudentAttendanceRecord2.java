package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceRecord2 {
    public boolean checkRecord(String s) {
        List<Integer> lateRecord = new ArrayList<>();
        int absentRecord = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentRecord++;
            } else if (s.charAt(i) == 'L') {
                lateRecord.add(i);
            }
        }

        boolean lateCriteria = true; //meeting criteria
        int count = 0;
        if (lateRecord.size() != 0) {
            for (int i = 0; i < lateRecord.size() -1; i++) {
                if (lateRecord.get(i + 1) - lateRecord.get(i) == 1) {
                    count++;
                    if (count == 2) {
                        return false;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return absentRecord < 2 && lateCriteria;
    }

    public static void main(String[] args) {
        String record = "PPALLLP";
        StudentAttendanceRecord2 studentAttendanceRecord2 = new StudentAttendanceRecord2();
        boolean res = studentAttendanceRecord2.checkRecord(record);
        System.out.println("PPALLLP" + " result: " + res);
    }
}
