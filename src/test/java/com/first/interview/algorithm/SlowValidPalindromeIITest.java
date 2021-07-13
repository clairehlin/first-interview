package com.first.interview.algorithm;

class SlowValidPalindromeIITest extends AbstractValidPalindromeIITest {

    @Override
    ValidPalindromeII validPalindromeII() {
        return new SlowValidPalindromeII();
    }
}