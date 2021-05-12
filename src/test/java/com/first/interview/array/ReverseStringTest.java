package com.first.interview.array;

class ReverseStringTest extends AbstractReverseTest {

    @Override
    protected Reverse reverse() {
        return new ReverseString();
    }
}
