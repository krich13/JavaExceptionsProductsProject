package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class ProductRepository {  //Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров)
    private Product[] items = new Product[0];

    public void save(Product item) {
        String name = item.getName();
        Product [] result = ProductManager.searchBy(item.getName());
        if (result.length != 0) {
            throw new ProductIsAlreadySaved("Element with name: " + name + " is already saved");
        };
            int length = items.length + 1;
            Product[] tmp = new Product[length];
            System.arraycopy(items, 0, tmp, 0, items.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(String id) {
        if (id == null) {
            throw new ProductIsAlreadyDeleted("Element with id: " + id + " is not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
