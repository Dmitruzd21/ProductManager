package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(3,"Дама с собачкой",678,"Чехов");
    @Test
    void shouldmatchesAuthorAndSearchAreTheSame() {
        boolean actual = book.matches("Чехов");
        assertTrue(actual);
    }

    @Test
    void shouldmatchesAuthorAndSearchAreNotTheSame() {
       boolean actual = book.matches("Достоевский");
        assertFalse(actual);
    }

}