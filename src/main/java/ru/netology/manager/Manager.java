package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class Manager {
private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

public void add (Product product){
        repository.save(product);
}
public Product[] searchBy(String text) {
Product[] products = repository.findAll();
Product[] tmp = new Product[1];
int index = 0;
for (product:products) {

}
        return;
}
}
