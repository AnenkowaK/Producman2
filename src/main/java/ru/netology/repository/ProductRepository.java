package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    //Сохранить продукт в массив
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //Найти все продукты
    public Product[] findAll() {

        return items;
    }

    //Найти продукт по id
    public Product findById(int id) {
        for (Product item : items) {
            if ((item.getId() == id)) {
                return item;
            }
        }
        return null;

    }

    //Удалить продукт по id
    public void removeById(int id) {

        Product foundProd;
        foundProd = findById(id);
        if (foundProd == null) {
            throw new NotFoundException("Продукт не найден. id = " + id);
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






