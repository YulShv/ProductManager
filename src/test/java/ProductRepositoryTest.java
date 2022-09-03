import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.product.Book;
import ru.netology.domain.product.Product;
import ru.netology.domain.product.ProductRepository;
import ru.netology.domain.product.Smartphone;

public class ProductRepositoryTest {
    Product product1 = new Product(1, "Product1", 500);
    Product product2 = new Product(2, "Product2", 430);
    Product book1 = new Book(3, "Book1", 300, "Ivanov");
    Product book2 = new Book(4, "Book2", 580, "Petrov");
    Product smartphone1 = new Smartphone(5, "Smartphone1", 11_000, "NoName");
    Product smartphone2 = new Smartphone(6, "Smartphone2", 12_000, "NoName");
    Product smartphone3 = new Smartphone(7, "Smartphone3", 20_000, "NoName0");

    @Test
    public void shouldFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {product1, product2, book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book2.getId());

        Product[] expected = {product1, product2, book1, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
