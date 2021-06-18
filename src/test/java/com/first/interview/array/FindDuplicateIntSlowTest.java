package com.first.interview.array;

class FindDuplicateIntSlowTest extends AbstractFindDuplicateIntTest {

    @Override
    FindDuplicate getFindDuplicateInt() {
        return new FindDuplicateIntSlow();
    }
}