package com.first.interview.array;

class FindDuplicateIntFastTest extends AbstractFindDuplicateIntTest {

    @Override
    FindDuplicate getFindDuplicateInt() {
        return new FindDuplicateIntFast();
    }
}