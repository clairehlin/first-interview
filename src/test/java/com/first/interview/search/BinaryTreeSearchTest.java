package com.first.interview.search;

import java.util.List;

class BinaryTreeSearchTest extends AbstractBinarySearchTest{

    @Override
    protected ListSearch listSearch(List<Integer> list) {
        return new BinaryTreeSearch(list);
    }
}