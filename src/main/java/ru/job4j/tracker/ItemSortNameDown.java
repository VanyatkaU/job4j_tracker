package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class ItemSortNameDown implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
