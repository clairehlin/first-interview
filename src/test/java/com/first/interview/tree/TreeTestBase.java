package com.first.interview.tree;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public abstract class TreeTestBase {

    // empty tree
    @Nested
    class EmptyTree {
        @Test
        void can_insert_into_empty_tree() {
            // given
            MTree tree = treeOf();

            // when
            tree.insert(5);

            // then
            assertThat(tree.size()).isEqualTo(1);
            assertThat(tree.contains(5)).isTrue();
            assertThat(tree.isEmpty()).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(5));
        }

        @Test
        void empty_tree_removal_specs() {
            // given
            MTree tree = treeOf();

            // when/then
            assertThat(tree.size()).isEqualTo(0);
            assertThat(tree.contains(7)).isFalse();
            assertThat(tree.isEmpty()).isTrue();
            assertThatCode(() -> tree.remove(7)).isInstanceOf(NoSuchElementException.class);
            assertThat(tree.infix()).isEqualTo(emptyList());
        }
    }

    /*
    5
     */
    @Nested
    class OneNodeTree {
        @Test
        void can_insert_smaller_value() {
            // given
            MTree tree = treeOf(5);

            // when
            tree.insert(3);

            // then
            assertThat(tree.size()).isEqualTo(2);
            assertThat(tree.contains(5)).isTrue();
            assertThat(tree.contains(3)).isTrue();
            assertThat(tree.contains(7)).isFalse();
            assertThat(tree.isEmpty()).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(3, 5));
        }

        @Test
        void can_insert_larger_value() {
            // given
            MTree tree = treeOf(5);

            // when
            tree.insert(7);

            // then
            assertThat(tree.size()).isEqualTo(2);
            assertThat(tree.contains(5)).isTrue();
            assertThat(tree.contains(7)).isTrue();
            assertThat(tree.contains(3)).isFalse();
            assertThat(tree.isEmpty()).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(5, 7));
        }

        @Test
        void empty_tree_removal_specs() {
            // given
            MTree tree = treeOf(5);

            // when/then
            assertThatCode(() -> tree.remove(7)).isInstanceOf(NoSuchElementException.class);

            // when
            tree.remove(5);

            // then
            assertThat(tree.size()).isEqualTo(0);
            assertThat(tree.contains(5)).isFalse();
            assertThat(tree.isEmpty()).isTrue();
            assertThat(tree.infix()).isEqualTo(emptyList());
        }
    }

    /*
      5
     /
    3
     */
    @Nested
    class LeftChildTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(5, 3);

            // when
            tree.insert(-1);
            tree.insert(4);
            tree.insert(0);
            tree.insert(7);

            // then
            assertThat(tree.size()).isEqualTo(6);
            IntStream.of(5, 3, -1, 4, 0, 7).forEach(
                    i -> assertThat(tree.contains(i)).isTrue()
            );
            IntStream.of(17, 18, -12).forEach(
                    i -> assertThat(tree.contains(i)).isFalse()
            );
            assertThat(tree.isEmpty()).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(-1, 0, 3, 4, 5, 7));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree1 = treeOf(5, 3);

            // when/then
            assertThatCode(() -> tree1.remove(7)).isInstanceOf(NoSuchElementException.class);

            // when
            tree1.remove(5);

            // then
            assertThat(tree1.size()).isEqualTo(1);
            assertThat(tree1.contains(5)).isFalse();
            assertThat(tree1.contains(3)).isTrue();
            assertThat(tree1.isEmpty()).isFalse();
            assertThat(tree1.infix()).isEqualTo(List.of(3));

            // given
            MTree tree2 = treeOf();
            tree2.insert(5);
            tree2.insert(3);

            // when
            tree2.remove(3);

            // then
            assertThat(tree2.size()).isEqualTo(1);
            assertThat(tree2.contains(5)).isTrue();
            assertThat(tree2.contains(3)).isFalse();
            assertThat(tree2.isEmpty()).isFalse();
            assertThat(tree2.infix()).isEqualTo(List.of(5));
        }
    }

    /*
      3
       \
        5 
     */
    @Nested
    class RightChildTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(3, 5);

            // when
            tree.insert(-1);
            tree.insert(4);
            tree.insert(0);
            tree.insert(7);

            // then
            assertThat(tree.size()).isEqualTo(6);
            IntStream.of(5, 3, -1, 4, 0, 7).forEach(
                    i -> assertThat(tree.contains(i)).isTrue()
            );
            IntStream.of(17, 18, -12).forEach(
                    i -> assertThat(tree.contains(i)).isFalse()
            );
            assertThat(tree.isEmpty()).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(-1, 0, 3, 4, 5, 7));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree1 = treeOf(3, 5);

            // when/then
            assertThatCode(() -> tree1.remove(7)).isInstanceOf(NoSuchElementException.class);

            // when
            tree1.remove(5);

            // then
            assertThat(tree1.size()).isEqualTo(1);
            assertThat(tree1.contains(5)).isFalse();
            assertThat(tree1.contains(3)).isTrue();
            assertThat(tree1.isEmpty()).isFalse();
            assertThat(tree1.infix()).isEqualTo(List.of(3));

            // given
            MTree tree2 = treeOf();
            tree2.insert(3);
            tree2.insert(5);

            // when
            tree2.remove(3);

            // then
            assertThat(tree2.size()).isEqualTo(1);
            assertThat(tree2.contains(5)).isTrue();
            assertThat(tree2.contains(3)).isFalse();
            assertThat(tree2.isEmpty()).isFalse();
            assertThat(tree2.infix()).isEqualTo(List.of(5));
        }
    }

    /*
         20
         /
        16
       /
      13
     /
    9
     */
    @Nested
    class LongLeftTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(20, 16, 13, 9);

            // when
            tree.insert(22);
            tree.insert(12);
            tree.insert(14);

            // then
            assertThat(tree.contains(14)).isTrue();
            assertThat(tree.contains(100)).isFalse();
            assertThat(tree.size()).isEqualTo(7);
            assertThat(tree.infix()).isEqualTo(List.of(9, 12, 13, 14, 16, 20, 22));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(20, 16, 13, 9);

            // when
            tree.remove(20);
            tree.remove(13);

            // then
            assertThat(tree.contains(16)).isTrue();
            assertThat(tree.contains(9)).isTrue();
            assertThat(tree.contains(20)).isFalse();
            assertThat(tree.size()).isEqualTo(2);
            assertThat(tree.infix()).isEqualTo(List.of(9, 16));
        }
    }

    /*
      20
      /
     10
       \
       16
       /
      12
       \
       14  
     */
    @Nested
    class StaggeredLeftTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(20, 10, 16, 12, 14);

            // when
            tree.insert(11);
            tree.insert(18);
            tree.insert(22);

            // then
            assertThat(tree.contains(22)).isTrue();
            assertThat(tree.contains(18)).isTrue();
            assertThat(tree.contains(100)).isFalse();
            assertThat(tree.size()).isEqualTo(8);
            assertThat(tree.infix()).isEqualTo(List.of(10, 11, 12, 14, 16, 18, 20, 22));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(20, 10, 16, 12, 14);

            // when
            tree.remove(14);
            tree.remove(10);

            // then
            assertThat(tree.contains(20)).isTrue();
            assertThat(tree.contains(10)).isFalse();
            assertThat(tree.size()).isEqualTo(3);
            assertThat(tree.infix()).isEqualTo(List.of(12, 16, 20));
        }
    }

    /*
       10
        \
         20
          \
           22
            \ 
             24
     */
    @Nested
    class LongRightTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(10, 20, 22, 24);

            // when
            tree.insert(8);
            tree.insert(7);
            tree.insert(12);
            tree.insert(25);

            // then
            assertThat(tree.size()).isEqualTo(8);
            assertThat(tree.contains(12)).isTrue();
            assertThat(tree.contains(25)).isTrue();
            assertThat(tree.infix()).isEqualTo(List.of(7, 8, 10, 12, 20, 22, 24, 25));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(10, 20, 22, 24);

            // when
            tree.remove(10);
            tree.remove(22);

            // then
            assertThat(tree.size()).isEqualTo(2);
            assertThat(tree.contains(20)).isTrue();
            assertThat(tree.contains(10)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(20,24));
        }
    }

    /*
    20
     \
      30
     /
    22
      \
      26
      /  
     25
     */
    @Nested
    class StaggeredRightTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(20, 30, 22, 26, 25);

            // when
            tree.insert(13);
            tree.insert(21);
            tree.insert(27);

            assertThat(tree.size()).isEqualTo(8);
            assertThat(tree.contains(13)).isTrue();
            assertThat(tree.contains(21)).isTrue();
            assertThat(tree.contains(100)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(13, 20, 21, 22, 25, 26, 27, 30));
        }
    }

    /*
      17
      / \
     13  28
    /  \
   10   15
     */
    @Nested
    class VanillaTree1 {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(17, 13, 28, 10, 15);

            // when
            tree.insert(12);
            tree.insert(14);
            tree.insert(18);

            // then
            assertThat(tree.size()).isEqualTo(8);
            assertThat(tree.contains(12)).isTrue();
            assertThat(tree.contains(14)).isTrue();
            assertThat(tree.contains(29)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(10, 12, 13, 14, 15, 17, 18, 28));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(17, 13, 28, 10, 15);

            // when
            tree.remove(17);
            tree.remove(13);

            // then
            assertThat(tree.size()).isEqualTo(3);
            assertThat(tree.contains(28)).isTrue();
            assertThat(tree.contains(15)).isTrue();
            assertThat(tree.contains(17)).isFalse();
        }
    }
    /*
          28
         / \
        5   50
           /  \
          33   80
              / \
             70  82
            / \
           60  72
        */
    @Nested
    class VanillaTree2 {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(28, 5, 50, 33, 80, 70, 82, 60, 72);

            // when
            tree.insert(6);
            tree.insert(40);
            tree.insert(65);
            tree.insert(90);

            // then
            assertThat(tree.size()).isEqualTo(13);
            assertThat(tree.contains(90)).isTrue();
            assertThat(tree.contains(70)).isTrue();
            assertThat(tree.contains(6)).isTrue();
            assertThat(tree.contains(100)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(5, 6, 28, 33, 40, 50, 60, 65, 70, 72, 80, 82, 90));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(28, 5, 50, 33, 80, 70, 82, 60, 72);

            // when
            tree.remove(28);

            // then
            assertThat(tree.infix()).isEqualTo(List.of(5, 33, 50, 60, 70, 72, 80, 82));

            // when
            tree.remove(70);

            // then
            assertThat(tree.contains(5)).isTrue();
            assertThat(tree.contains(28)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(5, 33, 50, 60, 72, 80, 82));

            // when
            tree.remove(60);

            // then
            assertThat(tree.size()).isEqualTo(6);
            assertThat(tree.infix()).isEqualTo(List.of(5, 33, 50, 72, 80, 82));
        }


    }

    /*
        10
        / \
       5  20
      /
     3
      \
       4
       */
    @Nested
    class FunTree {
        @Test
        void insertion_specs() {
            // given
            MTree tree = treeOf(10, 5, 3, 4, 20);

            // when
            tree.insert(7);
            tree.insert(22);

            // then
            assertThat(tree.size()).isEqualTo(7);
            assertThat(tree.contains(7)).isTrue();
            assertThat(tree.contains(22)).isTrue();
            assertThat(tree.contains(700)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(3, 4, 5, 7, 10, 20, 22));
        }

        @Test
        void removal_specs() {
            // given
            MTree tree = treeOf(10, 5, 3, 4, 20);

            // when
            tree.remove(10);

            // then
            assertThat(tree.contains(12)).isFalse();
            assertThat(tree.infix()).isEqualTo(List.of(3, 4, 5, 20));

            // when
            tree.remove(5);
            tree.remove(4);

            // then
            assertThat(tree.infix()).isEqualTo(List.of(3, 20));
        }
    }

    abstract MTree treeOf(int... ints);
}
