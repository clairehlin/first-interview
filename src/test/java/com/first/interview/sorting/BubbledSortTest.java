package com.first.interview.sorting;

public class BubbledSortTest extends AbstractSortTest{

    @Override
    protected Sort sorting() {
        return new BubbleSort();
    }
}
