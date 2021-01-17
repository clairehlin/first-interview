package com.first.interview.list;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

// add a negative position ?

class MLinkedListImplTest {

    @Test
    void length_should_be_zero_when_empty() {
        // given
        // when
        // these two are equivalent
//        MList<String> mList = new MLinkedListImpl<>(size -> new String[size]);
        MList<String> mList = new MLinkedListImpl<>();

        // then
        assertThat(mList.length()).isEqualTo(0);
    }

    @Test
    void length_should_reflect_number_of_elements_and_values() {
        // given
        // when
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("moran");

        // then
        assertThat(mList.length()).isEqualTo(1);
        assertThat(mList.get(0)).isEqualTo("moran");

        // when
        mList.add("sam");

        // then
        assertThat(mList.length()).isEqualTo(2);
        assertThat(mList.get(0)).isEqualTo("moran");
        assertThat(mList.get(1)).isEqualTo("sam");
    }

    @Test
    void cannot_get_an_element_from_a_position_bigger_than_array_size() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");

        // when/then
        assertThatCode(()->mList.get(100)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void can_check_if_an_array_contains_an_element() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");

        // when/then
        assertThat(mList.contains("b")).isEqualTo(Boolean.valueOf(true));
    }

    @Test
    void cannot_accept_a_null_element_to_check_in_contains() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");

        // when/then
        assertThatCode(() -> mList.contains(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void length_should_grow_gracefully_when_adding_elements() {
        // given
        // when
        MList<String> mList = new MLinkedListImpl<>();
        IntStream.range(0, 1000).forEach(i -> mList.add(String.valueOf(i)));

        // then
        assertThat(mList.length()).isEqualTo(1000);
    }

    @Test
    void cannot_add_an_element_in_a_negative_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();

        // when/then
        assertThatCode(() -> mList.add(-1, "a")).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void cannot_add_null_element() {
        // given
        MList<String> mList = new MLinkedListImpl<>();

        // when/then
        assertThatCode(() -> mList.add(null)).isInstanceOf(NullPointerException.class);

    }

    @Test
    void cannot_add_an_element_into_a_position_bigger_than_array_size() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");

        // when/then
        assertThatCode(() -> mList.add(10, "c")).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void can_remove_an_existing_element_by_an_element() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("c");

        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("b");
        assertThat(mList.get(2)).isEqualTo("c");
        assertThat(mList.length()).isEqualTo(3);

        // when
        mList.remove("b");

        // then
        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("c");
        assertThat(mList.length()).isEqualTo(2);
    }

    @Test
    void can_remove_an_existing_element_by_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("c");

        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("b");
        assertThat(mList.get(2)).isEqualTo("c");
        assertThat(mList.length()).isEqualTo(3);

        // when
        mList.remove(1);

        // then
        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("c");
        assertThat(mList.length()).isEqualTo(2);
    }

    @Test
    void can_remove_only_existing_element_by_an_element() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");

        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.length()).isEqualTo(1);

        // when
        mList.remove("a");

        // then
        assertThat(mList.length()).isEqualTo(0);
    }

    // test case: can remove the last existing element by position

    // create a list
    // add a single element to it
    // verify the list has one item
    // remove the single element by location 0
    // verify the list is empty
    @Test
    void can_remove_only_existing_element_by_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");

        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.length()).isEqualTo(1);

        // when
        mList.remove(0);

        // then
        assertThat(mList.length()).isEqualTo(0);
    }

    @Test
    void cannot_remove_a_non_existing_element() {
        // given
        MLinkedListImpl<String> mLinkedListImpl = new MLinkedListImpl<>();
        mLinkedListImpl.add("a");
        mLinkedListImpl.add("b");

        // when/then
        assertThatCode(() -> mLinkedListImpl.remove("c"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("cannot find element: c");
    }

    @Test
    void cannot_remove_a_null_element() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");

        // when/then
        assertThatCode(() -> mList.remove(null)).isInstanceOf(NullPointerException.class);
    }


    @Test
    void can_add_an_element_into_a_specific_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("f");

        // when
        mList.add(1, "c");

        // then
        assertThat(mList.length()).isEqualTo(4);
        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("c");
        assertThat(mList.get(2)).isEqualTo("b");
        assertThat(mList.get(3)).isEqualTo("f");
    }

    @Test
    void can_add_an_element_into_position_zero() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("f");

        // when
        mList.add(0, "c");

        // then
        assertThat(mList.length()).isEqualTo(4);
        assertThat(mList.get(0)).isEqualTo("c");
        assertThat(mList.get(1)).isEqualTo("a");
        assertThat(mList.get(2)).isEqualTo("b");
        assertThat(mList.get(3)).isEqualTo("f");
    }

    @Test
    void can_add_an_element_into_the_last_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("f");

        // when
        mList.add(3, "c");

        // then
        assertThat(mList.length()).isEqualTo(4);
        assertThat(mList.get(0)).isEqualTo("a");
        assertThat(mList.get(1)).isEqualTo("b");
        assertThat(mList.get(2)).isEqualTo("f");
        assertThat(mList.get(3)).isEqualTo("c");
    }

    @Test
    void can_add_an_element_into_empty_list_by_position() {
        // given
        MList<String> mList = new MLinkedListImpl<>();

        // when
        mList.add(0, "c");

        // then
        assertThat(mList.length()).isEqualTo(1);
        assertThat(mList.get(0)).isEqualTo("c");
    }

    @Test
    void cannot_remove_an_element_from_a_position_bigger_than_list_size() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("c");

        // when/then
        assertThatCode(() -> mList.remove(10)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatCode(() -> mList.remove(mList.length())).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void can_remove_all_the_same_elements_in_an_array() {
        // given
        MList<String> mList = new MLinkedListImpl<>();
        mList.add("a");
        mList.add("b");
        mList.add("a");

        // when
        mList.removeAll("a");

        // then
        assertThat(mList.length()).isEqualTo(1);
        assertThat(mList.get(0)).isEqualTo("b");
    }
}