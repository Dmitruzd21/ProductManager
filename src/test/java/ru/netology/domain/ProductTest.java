package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(4, "Война и мир", 675);

    @Test
    void shouldmatchesNameAndSearchAreTheSame() {
        boolean actual = product.matches("Война и мир");
        assertTrue(actual);
    }

    @Test
    void shouldmatchesNameAndSearchAreNotTheSame() {
        boolean actual = product.matches("Горе от ума");
        assertFalse(actual);
    }
}