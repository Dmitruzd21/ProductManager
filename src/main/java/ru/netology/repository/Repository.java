package ru.netology.repository;

import ru.netology.domain.Product;

import java.rmi.NotBoundException;

public class Repository {
    private Product[] products = new Product[0];

    // ***Добавление продукта
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    // ***Возвращает весь массив в прямом порядке
    public Product[] findAll() {
        return products;
    }

    // Возвращает объект по идентификатору (либо null, если такого объекта нет)
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // ***Удаление продукта по ID

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp2 = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp2[index] = product;
                index++;
            }
        }
        products = tmp2;

    }

    // public void removeById(int id) {
    //     try {
    //         Product[] tmp2 = new Product[products.length - 1];
    //         int index = 0;
    //         for (Product product : products) {
    //             if (product.getId() != id) {
    //                 tmp2[index] = product;
    //                 index++;
    //             }
    //         }
    //         products = tmp2;
    //     } catch (
    //             ArrayIndexOutOfBoundsException e) {
    //         System.out.println("Ошибочка");
    //     }
    // }

    //public void removeById(int id) {
    //     if (id > 4) {
    //         throw new RuntimeException("ID не должен быть больше 4: Вы ввели ID - " + id);
    //     }

    //     Product[] tmp2 = new Product[products.length - 1];
    //     int index = 0;
    //     for (Product product : products) {
    //         if (product.getId() != id) {
    //             tmp2[index] = product;
    //             index++;
    //         }
    //     }
    //     products = tmp2;

    // }

    // public void removeById(int id) throws Exception {
    //     if (id > 4) {
    //         throw new Exception("ID не должен быть больше 4: Вы ввели ID - " + id);
    //     }

    //     Product[] tmp2 = new Product[products.length - 1];
    //     int index = 0;
    //     for (Product product : products) {
    //         if (product.getId() != id) {
    //             tmp2[index] = product;
    //             index++;
    //         }
    //     }
    //     products = tmp2;

    // }


}
