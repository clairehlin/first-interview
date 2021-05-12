package com.first.interview.array;

class ReverseWithSwapTest extends AbstractReverseTest {

    @Override
    protected Reverse reverse() {
        return new ReverseWithSwap();
    }
}