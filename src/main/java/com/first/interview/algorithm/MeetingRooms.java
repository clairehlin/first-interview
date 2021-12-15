package com.first.interview.algorithm;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            int meeting1StartTime = intervals[i][0];
            int meeting1EndTime = intervals[i][1];

            for (int j = i + 1; j < intervals.length; j++) {
                int meeting2StartTime = intervals[j][0];
                int meeting2EndTime = intervals[j][1];

                if (meeting1EndTime > meeting2StartTime) {
                    if (meeting1StartTime < meeting2EndTime) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
