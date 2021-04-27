package com.first.interview.search;

import java.util.List;

class BinaryArraySearchTest extends AbstractBinarySearchTest{

    @Override
    protected BinaryArraySearch listSearch(List<Integer> list) {
        return new BinaryArraySearch(list);
    }
}