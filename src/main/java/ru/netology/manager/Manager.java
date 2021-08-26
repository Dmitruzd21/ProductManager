package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.save(product);
    }


    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                //(из какого массива, с какого места из источника, куда копировать,с какого места всавлять вцелевой, количество элементов которые хотим скопировать)
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


}




