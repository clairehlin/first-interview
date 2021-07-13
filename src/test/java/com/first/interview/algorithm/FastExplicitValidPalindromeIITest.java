package com.first.interview.algorithm;

class FastExplicitValidPalindromeIITest extends AbstractValidPalindromeIITest {

    @Override
    ValidPalindromeII validPalindromeII() {
        return new FastExplicitValidPalindromeII();
    }
}