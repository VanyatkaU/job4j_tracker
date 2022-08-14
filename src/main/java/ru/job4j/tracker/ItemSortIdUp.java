package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class ItemSortIdUp implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(first.getId(), second.getId());
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }
}
