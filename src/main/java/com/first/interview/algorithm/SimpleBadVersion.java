package com.first.interview.algorithm;

public class SimpleBadVersion implements BadVersion{
    @Override
    public boolean isBadVersion(int version) {
        return version >= 2;
    }
}
