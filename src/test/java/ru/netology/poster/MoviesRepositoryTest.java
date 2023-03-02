package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoviesRepositoryTest {
    PurchaseItem item1 = new PurchaseItem(1, "Film 1");
    PurchaseItem item2 = new PurchaseItem(11, "Film 2");
    PurchaseItem item3 = new PurchaseItem(111, "Film 3");

    MoviesRepository repo = new MoviesRepository();
    private MovieManager manager = new MovieManager(repo);

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }
    @Test
    public void testSave() {

        PurchaseItem[] expected = {item1, item2, item3};
        PurchaseItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveById() {

        repo.removeById(item2.getId());

        PurchaseItem[] expected = {item1, item3};
        PurchaseItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveAll() {

        repo.removeAll();

        PurchaseItem[] expected = {};
        PurchaseItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindById() {

        repo.findById(item2.getId());

        PurchaseItem expected = item2;
        PurchaseItem actual = repo.findById(11);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindByIdNotItem() {

        PurchaseItem expected = null;
        PurchaseItem actual = repo.findById(3);

        Assertions.assertEquals(expected, actual);
    }
}
