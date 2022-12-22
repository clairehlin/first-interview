package com.first.interview.solution.based;

public class RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int substringLength = 1;

        while (substringLength <= length / 2) {
            // find repeated substring
            if(findRepeated(s, substringLength)) {
                return true;
            }

            // if not found, go to next substring
            substringLength++;
        }
        return false;
    }

    private boolean findRepeated(String s, int substringLength) {
        if (s.length() % substringLength != 0) {
            return false;
        }

        // numOfMatches - potentially the number of matching substrings
        int numOfMatches = s.length() / substringLength - 1;
        int count = 1;
        int startPosOfRemain = substringLength;

        while (count <= numOfMatches) {
            for (int substringStart = 0; startPosOfRemain < (count + 1) * substringLength; startPosOfRemain++, substringStart++) {
                if (s.charAt(substringStart) != s.charAt(startPosOfRemain)) {
                    return false;
                }
            }
            count++;
        }
        return true;
    }
}
