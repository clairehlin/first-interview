package com.first.interview.array;

class FindMaxSumVerySlowTest extends AbstractFindMaxSumTest {

    @Override
    protected FindMaxSum findMaxSum() {
        return new FindMaxSumVerySlow();
    }
}