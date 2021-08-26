package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] products = new Product[0];

    // ***Добавление продукта
    public void save(Product product) {
        Product[] tmp = new Product[products.length+1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    // ***Возвращает весь массив в прямом порядке
    public Product[] findAll() {
        Product[] result = new Product[products.length];
        for (int i = 0; i < products.length; i++) {
            result[i] = products[i];
        }
        return result;
    }

    // ***Удаление продукта по ID
    public void removeById(int id) {
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
}
