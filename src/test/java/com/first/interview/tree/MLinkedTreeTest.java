package com.first.interview.tree;

class MLinkedTreeTest extends TreeTestBase {

    @Override
    MTree treeOf(int... ints) {
        MLinkedTree tree = new MLinkedTree();
        for (int i : ints) {
            tree.insert(i);
        }
        return tree;
    }
}