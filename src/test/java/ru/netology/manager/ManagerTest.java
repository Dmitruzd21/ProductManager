package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Something;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
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
    Something g1 = new Something(5,"jhgh",543,"fff");

    @BeforeEach
    public void setUp() {
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
        manager.add(s4);
        manager.add(s5);
    }

    //1. Поиск книг

    ///1.1 поиск по имени

    ////1.1.1. нет продуктов с именем книги
    @Test
    void shouldsearchByIfNoBookWithName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Вечера на хуторе близ диканьки");
        assertArrayEquals(expected, actual);
    }

    ////1.1.2 есть 1 продукт с именем книги
    @Test
    void shouldsearchByIf1BookWithNameExist() {
        Product[] expected = new Product[]{b3};
        Product[] actual = manager.searchBy("Евгений Онегин");
        assertArrayEquals(expected, actual);
    }

    ////1.1.3. есть 2 продукта с именем книги
    @Test
    void shouldsearchByIf2BooksWithNameExist() {
        Product[] expected = new Product[]{b1, b5};
        Product[] actual = manager.searchBy("Война и Мир");
        assertArrayEquals(expected, actual);
    }

    ///1.2 поиск по автору

    ////1.2.1 нет продуктов с автором
    @Test
    void shouldsearchByIfNotBookWithAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Чехов");
        assertArrayEquals(expected, actual);
    }

    ////1.2.2. есть 1 продукт с автором
    @Test
    void shouldsearchByIf1BookWithAuthorExist() {
        Product[] expected = new Product[]{b2};
        Product[] actual = manager.searchBy("Ф.М.Достоевский");
        assertArrayEquals(expected, actual);
    }

    ////1.2.3 есть 3 продукта с автором
    @Test
    void shouldsearchByIf3BooksWithAuthorExist() {
        Product[] expected = new Product[]{b1, b4, b5};
        Product[] actual = manager.searchBy("Л.Н.Толстой");
        assertArrayEquals(expected, actual);
    }

    //2. Поиск смартфонов

    ///2.1 поиск по имени

    ////2.1.1 нет продуктов с именем смартфона
    @Test
    void shouldsearchByIfNoSmartphoneWithName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    ////2.1.2 есть 1 продукт с именем смартфона
    @Test
    void shouldsearchByIf1SmartphoneWithNameExist() {
        Product[] expected = new Product[]{s4};
        Product[] actual = manager.searchBy("Goldensmartphone");
        assertArrayEquals(expected, actual);
    }

    ////2.1.3 есть 2 продукта с именем смартфона
    @Test
    void shouldsearchByIf2SmartphonesWithNameExist() {
        Product[] expected = new Product[]{s2, s5};
        Product[] actual = manager.searchBy("Supersmartphone");
        assertArrayEquals(expected, actual);
    }

    ///2.2 поиск по производителю

    ////2.2.1 нет продукта с производителем
    @Test
    void shouldsearchByIfNoSmartphoneWithManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("China");
        assertArrayEquals(expected, actual);
    }

    ////2.2.2 есть 1 продукт с производителем
    @Test
    void shouldsearchByIf1SmartphoneWithManufacturerExist() {
        Product[] expected = new Product[]{s4};
        Product[] actual = manager.searchBy("Germany");
        assertArrayEquals(expected, actual);
    }

    ////2.2.3 есть 3 продукта с производетелем
    @Test
    void shouldsearchByIf2SmartphonesWithManufacturerExist() {
        Product[] expected = new Product[]{s1, s2, s5};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

   // @BeforeEach
   // public void setUp2() {
  //      manager.add (g1);
  //  }
       //Тест для обеспечения тестового покрытия по branch метода searchBy
       // Не выполняется условие для приведения типа (кастинга)
     //  @Test
     //   void shouldsearchByIf2SmartphonesWithManufacturerExist2 () {
      //      Product[] expected = new Product[]{};
      //     Product[] actual = manager.searchBy("hgh");
      //      assertArrayEquals(expected, actual);
      //  }

    }