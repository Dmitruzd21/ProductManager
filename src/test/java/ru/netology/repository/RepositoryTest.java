package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    Product b1 = new Book(1, "Война и Мир", 900, "Л.Н.Толстой");
    Product b2 = new Book(2, "Преступление и наказание", 700, "Ф.М.Достоевский");
    Product s1 = new Smartphone(3, "Goodsmartphone", 4500, "USA");
    Product s2 = new Smartphone(4, "Supersmartphone", 9500, "USA");

    @BeforeEach
    public void setUp() {
        repository.save(b1);
        repository.save(b2);
        repository.save(s1);
        repository.save(s2);
    }
    //Проверка удаления объекта по идентификатору

    ///Объект с идентификатором существует
    @Test
    void shouldremoveByIdIfProductWithIdExist() {
        repository.removeById(2);
        Product[] expected = new Product[]{b1, s1, s2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    ///Объект с идентификатором НЕ существует

    @Test
    void shouldThrowNotFoundExeptionIfProductWithIdNotExist() {
        assertThrows(NotFoundExeption.class, () -> {
            repository.removeById(7);
        });
    }

}