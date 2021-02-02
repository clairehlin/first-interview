package com.first.interview.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class FastHashMapTest {

    @Test
    void can_put_and_get_elements() {
        // given
        Product product1 = product("123", "bike", 200);
        Product product2 = product("456", "short skirt", 100);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);
        fastHashMap.put(product2.serialNumber, product2);

        // then
        assertThat(fastHashMap.get(product1.serialNumber)).isEqualTo(product1);
        assertThat(fastHashMap.get(product2.serialNumber)).isEqualTo(product2);
    }

    @Test
    void cannot_get_with_a_null_key() {
        // given
        Product product1 = product("123", "bike", 200);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);

        // then
        assertThatCode(() -> fastHashMap.get(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("key cannot be null");
    }

    @Test
    void can_get_and_put_large_numbers_of_elements() {
        // given
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        assertThat(fastHashMap.length()).isEqualTo(0);

        // when
        IntStream.range(0, 1000).forEach(i -> fastHashMap.put(String.valueOf(i), product(i)));

        // then
        assertThat(fastHashMap.length()).isEqualTo(1000);
        assertThat(fastHashMap.get("1").name).isEqualTo(product(1).name);
        assertThat(fastHashMap.get("100").name).isEqualTo(product(100).name);
        assertThat(fastHashMap.get("200").name).isEqualTo(product(200).name);
        assertThat(fastHashMap.get("900").name).isEqualTo(product(900).name);
        // another better way to check the product in the map is to rely on the equals and hashcode method as follows
        IntStream.range(0, 1000).forEach(
                i -> assertThat(
                        fastHashMap.get(String.valueOf(i))
                ).isEqualTo(
                        product(i)
                )
        );
    }


    @Test
    void cannot_put_a_null_key_or_null_value() {
        // given
        Product product1 = product("123", "bike", 200);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();

        // then
        assertThatCode(() -> fastHashMap.put(null, product1)).isInstanceOf(NullPointerException.class);
        assertThatCode(() -> fastHashMap.put("123", null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void cannot_put_two_elements_with_the_same_key() {
        // given
        Product product1 = product("123", "bike", 200);
        Product product2 = product("123", "bike", 200);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put("123", product1);


        // then
        assertThatCode(() -> fastHashMap.put("123", product2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("key already exists");
    }

    @Test
    void cannot_get_non_existing_key() {
        // given/when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put("123", product(1));


        // then
        assertThatCode(() -> fastHashMap.get("789")).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void can_remove_an_element_with_a_key() {
        // given
        Product product1 = product("123", "bike", 200);
        Product product2 = product("456", "short skirt", 100);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);
        fastHashMap.put(product2.serialNumber, product2);
        assertThat(fastHashMap.length()).isEqualTo(2);

        // then
        fastHashMap.remove("123");
        assertThat(fastHashMap.length()).isEqualTo(1);
        assertThatCode(() -> fastHashMap.get("123")).isInstanceOf(NoSuchElementException.class);


        // when
        fastHashMap.remove("456");
        assertThat(fastHashMap.length()).isEqualTo(0);
        assertThatCode(() -> fastHashMap.get("456")).isInstanceOf(NoSuchElementException.class);

    }

    @Test
    void cannot_remove_a_non_existing_key() {
        // given
        Product product1 = product("123", "bike", 200);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);

        // then
        assertThatCode(() -> fastHashMap.remove("789")).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void cannot_remove_an_element_with_a_null_key() {
        // given
        Product product1 = product("123", "bike", 200);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);

        // then
        assertThatCode(() -> fastHashMap.remove(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void can_check_if_map_is_empty() {
        // given/when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();

        // then
        assertThat(fastHashMap.isEmpty()).isTrue();

        // when
        fastHashMap.put("123", product(1));

        // then
        assertThat(fastHashMap.isEmpty()).isFalse();
    }

    @Test
    void can_get_map_size() {
        // given
        Product product1 = product("123", "bike", 200);
        Product product2 = product("456", "short skirt", 100);

        // when
        FastHashMap<String, Product> fastHashMap = new FastHashMap<>();
        fastHashMap.put(product1.serialNumber, product1);
        fastHashMap.put(product2.serialNumber, product2);

        // then
        assertThat(fastHashMap.length()).isEqualTo(2);
    }

    // utils

    private Product product(int i) {
        return product(String.valueOf(i), "name" + i, 100 + i);
    }

    private Product product(String serialNumber, String productName, int price) {
        Product product = new Product();
        product.serialNumber = serialNumber;
        product.name = productName;
        product.price = price;
        return product;
    }

    private static class Product {
        private String serialNumber;
        private String name;
        private int price;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return price == product.price && Objects.equals(serialNumber, product.serialNumber) && Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(serialNumber, name, price);
        }
    }


}