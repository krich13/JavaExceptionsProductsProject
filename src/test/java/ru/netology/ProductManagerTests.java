package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductIsAlreadyDeleted;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTests {
    ProductManager productManager = new ProductManager(new ProductRepository());
    Product firstBook = new Book(1, "Martin Eden", 600, "Jack London");
    Product secondBook = new Book(2, "The Iron Heel", 600, "Jack London");
    Product firstTShirt = new TShirt(3, "Zara", 1000, "China");
    Product secondTShirt = new TShirt(4, "Bershka", 1100, "Vietnam");
    Product product = new Product();
    Product thirdTShirt = new Product();

    @BeforeEach
    public void setUp() {
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(firstTShirt);
        productManager.add(secondTShirt);
        productManager.add(product);
    }

    @Test
    void shouldFindBookByName() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = productManager.searchBy("Martin Eden");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindBookByAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = productManager.searchBy("Jack London");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTSirtByProducer() {
        Product[] expected = new Product[]{firstTShirt};
        Product[] actual = productManager.searchBy("China");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTShirtByName() {
        Product[] expected = new Product[]{firstTShirt};
        Product[] actual = productManager.searchBy("Zara");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductByNameIfFiltersDoNotSuit() {
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductIfItIsAnotherInstance() {
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldDeleteItemById() {
        productManager.delete(firstTShirt);
        Product[] actual = productManager.searchBy(firstBook.getId());
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldThrowNegativeException() {
        assertThrows(ProductIsAlreadyDeleted.class, () -> productManager.delete(thirdTShirt));
    }
}

        /*try { productManager.delete(firstTShirt); //так не тестируют, но лямда выражение значит это
            fail();
        } catch (ProductIsAlreadyDeleted e) {
        }    catch (Exception e) {
        }
        fail();
    }
}*/

