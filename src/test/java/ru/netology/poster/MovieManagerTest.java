package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MovieManagerTest {

    MoviesRepository repo = Mockito.mock(MoviesRepository.class);
    MovieManager manager = new MovieManager(repo);

    PurchaseItem item1 = new PurchaseItem(1, "Film 1");
    PurchaseItem item2 = new PurchaseItem(11, "Film 2");
    PurchaseItem item3 = new PurchaseItem(111, "Film 3");
    PurchaseItem item4 = new PurchaseItem(2, "Film 4");
    PurchaseItem item5 = new PurchaseItem(22, "Film 5");
    PurchaseItem item6 = new PurchaseItem(222, "Film 6");
    PurchaseItem item7 = new PurchaseItem(3, "Film 7");
    PurchaseItem item8 = new PurchaseItem(33, "Film 8");
    PurchaseItem item9 = new PurchaseItem(333, "Film 9");
    PurchaseItem item10 = new PurchaseItem(4, "Film 10");
    PurchaseItem item11 = new PurchaseItem(44, "Film 11");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
    }

    // Вывод максимального лимита* последних добавленных фильмов в обратном от добавления порядке

    @Test
    public void shouldAllItemNoMoreLimit() {
        PurchaseItem[] items = { item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11 };
        doReturn(items).when(repo).findAll();

        PurchaseItem[] expected = { item11, item10, item9, item8, item7, item6, item5, item4, item3, item2 };
        PurchaseItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
