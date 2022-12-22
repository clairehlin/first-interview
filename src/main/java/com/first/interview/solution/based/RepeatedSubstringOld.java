package com.first.interview.solution.based;

public class RepeatedSubstringOld {
        public boolean repeatedSubstringPattern(String s) {
            int length = s.length();
            int count = 1;

            while (count <= length / 2) {
                // form a substring
                String substring = s.substring(0, count);

                // find repeated substring
                if(findRepeated(substring, s)) {
                    return true;
                }

                // if not found, go to next substring
                count++;
            }
            return false;
        }

        private boolean findRepeated(String substring, String s) {
            if (s.length() % substring.length() != 0) {
                return false;
            }

            int loopTimes = s.length() / substring.length() - 1;
            int count = 1;
            int substringLength = substring.length();
            int start = substringLength;

            while (count <= loopTimes) {
                for (int substringStart = 0; start < (count + 1) * substringLength; start++, substringStart++) {
                    if (substring.charAt(substringStart) != s.charAt(start)) {
                        return false;
                    }
                }
                count++;
            }
            return true;
        }
}
