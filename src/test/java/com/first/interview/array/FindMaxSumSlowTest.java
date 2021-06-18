package com.first.interview.array;

class FindMaxSumSlowTest extends AbstractFindMaxSumTest {

    @Override
    protected FindMaxSum findMaxSum() {
        return new FindMaxSumSlow();
    }
}