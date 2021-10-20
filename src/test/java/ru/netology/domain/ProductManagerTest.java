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
    Book coreJava = new Book(1, "aqqq", 1, "bww");
    Smartphone samsung = new Smartphone(2, "aeee", 2, "brrrr");
    TShirt polo = new TShirt(3, "appp", 3, "lllb", "xl");

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
    public void shouldSearchProductBookName() {
        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("qqq");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductBookAuthor() {
        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("bww");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductSmartphoneName() {
        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy("aeee");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductSmartphoneManufacturer() {
        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy("brrrr");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductTShirtName() {
        Product[] expected = new Product[]{polo};
        Product[] actual = manager.searchBy("appp");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductTShirtColor() {
        Product[] expected = new Product[]{polo};
        Product[] actual = manager.searchBy("lllb");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductTShirtSize() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("xl");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductAllName() {
        Product[] expected = new Product[]{coreJava, samsung, polo};
        Product[] actual = manager.searchBy("a");
        assertArrayEquals(expected, actual);
    }
}
















