package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ItemTest {

    @Test
    public void itemSortNameUp() {
        Item item = new Item(3, "Ivan");
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(5, "Stepan");
        Item item3 = new Item(4, "Nikita");
        List<Item> items = Arrays.asList(item, item1, item2, item3);
        items.sort(new ItemSortNameUp());
        List<Item> expect = Arrays.asList(item1, item, item3, item2);
        Assert.assertEquals(items, expect);
    }

    @Test
    public void itemSortNameDown() {
        Item item = new Item(3, "Ivan");
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(5, "Stepan");
        Item item3 = new Item(4, "Nikita");
        List<Item> items = Arrays.asList(item, item1, item2, item3);
        items.sort(new ItemSortNameDown());
        List<Item> expect = Arrays.asList(item2, item3, item, item1);
        Assert.assertEquals(items, expect);
    }

    @Test
    public void itemSortIdUp() {
        Item item = new Item(3, "Ivan");
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(5, "Stepan");
        Item item3 = new Item(4, "Nikita");
        List<Item> items = Arrays.asList(item, item1, item2, item3);
        items.sort(new ItemSortIdUp());
        List<Item> expect = Arrays.asList(item1, item, item3, item2);
        Assert.assertEquals(items, expect);
    }

    @Test
    public void itemSortIdDown() {
        Item item = new Item(3, "Ivan");
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(5, "Stepan");
        Item item3 = new Item(4, "Nikita");
        List<Item> items = Arrays.asList(item, item1, item2, item3);
        items.sort(new ItemSortIdDown());
        List<Item> expect = Arrays.asList(item2, item3, item, item1);
        Assert.assertEquals(items, expect);
    }
}
