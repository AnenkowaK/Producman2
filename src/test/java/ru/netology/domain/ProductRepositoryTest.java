package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    Book coreJava = new Book(1, "qqq", 1, "www");
    Smartphone samsung = new Smartphone(2, "eee", 2, "rrrr");
    TShirt polo = new TShirt(3, "ppp", 3, "lll", "xl");

    ProductRepository repository = new ProductRepository();

    //метод добавления этих продуктов перед каждым тестом
    @BeforeEach
    public void setUp() {
        repository.save(coreJava);
        repository.save(samsung);
        repository.save(polo);
    }

    @Test
    public void remoteExistingId() {
        repository.removeById(3);
        Product[] expected = {coreJava, samsung};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void nonExistingId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }
}
