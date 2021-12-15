package com.first.interview.algorithm;

public class IsBadVersion extends VersionControl{

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        IsBadVersion isBadVersion = new IsBadVersion();
        System.out.println(isBadVersion.firstBadVersion(7));
    }
}
