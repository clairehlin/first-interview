package com.first.interview.tree;

class MArrayTreeTest extends TreeTestBase {

    @Override
    MTree treeOf(int... ints) {
        MArrayTree tree = new MArrayTree();
        for (int i : ints) {
            tree.insert(i);
        }
        return tree;
    }
}