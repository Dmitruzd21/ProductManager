package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphone = new Smartphone(6,"VIPSmartphone",345,"Китай");
    @Test
    void shouldmatchesManufacturerAndSearchAreTheSame() {
        boolean actual = smartphone.matches("Китай");
        assertTrue(actual);
    }

    @Test
    void shouldmatchesManufacturerAndSearchAreNotTheSame() {
        boolean actual = smartphone.matches("Япония");
        assertFalse(actual);
    }
}