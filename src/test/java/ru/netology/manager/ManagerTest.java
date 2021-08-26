package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Product b1 = new Book(1, "Война и Мир", 900, "Л.Н.Толстой");
    Product b2 = new Book(2, "Преступление и наказание", 700, "Ф.М.Достоевский");
    Product b3 = new Book(3, "Евгений Онегин", 456, "А.С.Пушкин");
    Product b4 = new Book(4, "Анна Каренина", 567, "Л.Н.Толстой");
    Product b5 = new Book(5, "Война и Мир", 567, "Л.Н.Толстой");
    Product s1 = new Smartphone(6, "Goodsmartphone", 4500, "USA");
    Product s2 = new Smartphone(7, "Supersmartphone", 9500, "USA");
    Product s3 = new Smartphone(8, "Woodmartphone", 1500, "Russia");
    Product s4 = new Smartphone(9, "Goldensmartphone", 44500, "Germany");
    Product s5 = new Smartphone(10, "Supersmartphone", 13500, "USA");

    //1. Поиск книг

    ///1.1 поиск по имени

    ////1.1.1. нет продуктов с именем книги
    @Test
    void shouldsearchByIfNoProductWithName() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.searchBy("Вечера на хуторе близ диканьки");
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////1.1.2 есть 1 продукт с именем книги
    @Test
    void shouldsearchBy2() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.searchBy("Евгений Онегин");
        Product[] expected = new Product[]{b3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////1.1.3. есть 2 продукта с именем книги
    @Test
    void shouldsearchBy3() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.searchBy("Война и Мир");
        Product[] expected = new Product[]{b1, b5};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ///1.2 поиск по автору

    ////1.2.1 нет продуктов с автором
    @Test
    void shouldsearchBy4() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.searchBy("Чехов");
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////1.2.2. есть 1 продукт с автором
    @Test
    void shouldsearchBy5() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.searchBy("Ф.М.Достоевский");
        Product[] expected = new Product[]{b2};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////1.2.3 есть 3 продукта с автором
    @Test
    void shouldsearchBy6() {
        Manager manager = new Manager();
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.searchBy("Л.Н.Толстой");
        Product[] expected = new Product[]{b1, b4, b5};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }


    //2. Поиск смартфонов

    ///2.1 поиск по имени

    ////2.1.1 нет продуктов с именем смартфона
    @Test
    void shouldsearchBy7() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("Galaxy");
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////2.1.2 есть 1 продукт с именем смартфона
    @Test
    void shouldsearchBy8() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("Goldensmartphone");
        Product[] expected = new Product[]{s4};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////2.1.3 есть 2 продукта с именем смартфона
    @Test
    void shouldsearchBy9() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("Supersmartphone");
        Product[] expected = new Product[]{s2, s5};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ///2.2 поиск по производителю

    ////2.2.1 нет продукта с производителем
    @Test
    void shouldsearchBy10() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("China");
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////2.2.2 есть 1 продукт с производителем
    @Test
    void shouldsearchBy11() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("Germany");
        Product[] expected = new Product[]{s4};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    ////2.2.3 есть 2 продукта с производетелем
    @Test
    void shouldsearchBy12() {
        Manager manager = new Manager();
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
        manager.searchBy("USA");
        Product[] expected = new Product[]{s1, s2};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
}