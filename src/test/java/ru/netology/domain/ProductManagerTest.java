package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.manager.ProductManager;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    Book coreJava = new Book(1, "qqq", 1, "www");
    Smartphone samsung = new Smartphone(2, "eee", 2, "rrrr");
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(coreJava);
        manager.add(samsung);
    }

    @Test
    public void shouldSearchProductBook() {
        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("qqq");
        assertArrayEquals(expected, actual);
    }
}












