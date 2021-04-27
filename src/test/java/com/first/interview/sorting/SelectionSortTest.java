package com.first.interview.sorting;

class SelectionSortTest extends AbstractSortTest {

    @Override
    protected Sort sorting() {
        return new SelectionSort();
    }
}