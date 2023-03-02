package ru.netology.poster;

public class MovieManager {

    private MoviesRepository repo;
    private int limit;

    public MovieManager(MoviesRepository repo) {
        this.repo = repo;
        this.limit = 10;
    }

    public MovieManager(MoviesRepository repo, int limit) {
        this.repo = repo;
        this.limit = limit;
    }

    // Добавление нового фильма
    public void add(PurchaseItem item) {
        repo.save(item);
    }

    //Удаляет объект по идентификатору
    public void removeById(int id) {
        repo.removeById(id);
    }

    // Вывод всех фильмов в порядке добавления
    public void findAll() {
        repo.findAll();
    }

    // Вывод максимального лимита* последних добавленных фильмов в обратном от добавления порядке
    public PurchaseItem[] getItems() {

        PurchaseItem[] all = repo.findAll();
        int resultLength;
        if (all.length < limit) {
            resultLength = all.length;
        } else {
            resultLength = limit;
        }

        PurchaseItem[] reversed = new PurchaseItem[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }
}
