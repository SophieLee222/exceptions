package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();
    Product item1 = new Product(12, "book", 1000);

    @Test
    public void shouldRemoveExistingElement() {
        repo.add(item1);
        repo.remove(12);

        Product expected = null;
        Product actual = repo.findById(12);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGenerateNotFoundException() {
        repo.add(item1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(14);
        });
    }

    @Test
    public void shouldAddElement() {
        repo.add(item1);

        Product expected = item1;
        Product actual = repo.findById(12);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGenerateAlreadyExistsException() {
        repo.add(item1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.addById(12);
        });
    }
}
