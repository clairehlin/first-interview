package com.first.interview.algorithm;

import java.util.*;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        return listOf(typed).equals(listOf(name));
    }

    private List<Letter> listOf(String name) {
        List<Letter> res = new ArrayList<>();

        for (int i = 0; i < name.length(); i++) {
            if (i == 0 || name.charAt(i) != name.charAt(i - 1)) {
                res.add(new Letter(name.charAt(i), 1));
            } else {
                res.get(res.size() - 1).increment();
            }
        }
        return res;
    }

    private static class Letter {
        private char c;
        private int count;

        public Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }

        private void increment() {
            this.count++;
        }

        // a, 7
        // a, 6
        // c, 6

        // all equal objects have the same hash
        // some non-equal objects have the same hash
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Letter letter = (Letter) o;
            return c == letter.c && count >= letter.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }
}
