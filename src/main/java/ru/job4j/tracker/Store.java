package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.List;

public interface Store {
    Item add(Item item);

    default boolean replace(int id, Item item) {
        return false;
    }

    boolean delete(int id);

    default List<Item> findAll() {
        return null;
    }

    List<Item> findByName(String key);

    default Item findById(int id) {
        return null;
    }
}