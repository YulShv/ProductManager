import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.product.*;

public class ProductManagerTest {
    Product product1 = new Product(1, "Product1", 500);
    Product product2 = new Product(2, "Product2", 430);
    Product book1 = new Book(3, "Book1", 300, "Ivanov");
    Product book2 = new Book(4, "Book2", 580, "Petrov");
    Product smartphone1 = new Smartphone(5, "Smartphone1", 11_000, "NoName");
    Product smartphone2 = new Smartphone(6, "Smartphone2", 12_000, "NoName");
    Product smartphone3 = new Smartphone(7, "Smartphone3", 20_000, "NoName0");

    @Test
    public void shouldFindTwo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Book1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("paper");

        Assertions.assertArrayEquals(expected, actual);
    }
}


