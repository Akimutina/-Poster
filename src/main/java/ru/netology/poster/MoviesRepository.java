package ru.netology.poster;

public class MoviesRepository {

    private PurchaseItem[] items = new PurchaseItem[0];

    //save — добавляет объект в массив
    public void save(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    //findAll — возвращает массив всех хранящихся в массиве объектов.
    public PurchaseItem[] findAll() {
        return items;
    }

    //removeById — удаляет объект по идентификатору
    public void removeById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
        int copyToIndex = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    //removeAll* — полностью вычищает репозиторий, для удаления всех элементов достаточно в поле items положить пустой массив.
    public PurchaseItem[] removeAll() {
        PurchaseItem[] tmp = new PurchaseItem[0];
        return items = tmp;
    }


    //findById — возвращает объект по идентификатору, либо null, если такого объекта нет.
    public PurchaseItem findById(int id) {
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
