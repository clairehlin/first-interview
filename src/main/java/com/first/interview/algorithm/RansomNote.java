package com.first.interview.algorithm;
// leetcode 383

import java.util.LinkedList;
import java.util.Queue;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < magazine.length(); i++) {
            queue.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (ransomNote.charAt(i) != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}
