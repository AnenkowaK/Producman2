package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.manager.ProductManager;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import javax.swing.*;


public class ProductManagerTest {
    Book coreJava = new Book(1, "qqq", 1, "www");
    Smartphone samsung = new Smartphone(2, "eee", 2, "rrrr");
    TShirt polo = new TShirt(3, "ppp", 3, "lll", "xl");

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    //метод добавления этих продуктов перед каждым тестом
    @BeforeEach
    public void setUp() {
        manager.add(coreJava);
        manager.add(samsung);
        manager.add(polo);
    }

    @Test
    public void shouldSearchProductBook() {
        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("qqq");
        assertArrayEquals(expected, actual);
    }
}
















