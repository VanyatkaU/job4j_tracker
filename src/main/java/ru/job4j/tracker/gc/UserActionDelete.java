package ru.job4j.tracker.gc;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.model.Item;

import java.util.List;

public class UserActionDelete implements UserAction {

    private final Output out;

    public UserActionDelete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete items ====");
        List<Item> items = memTracker.findAll();
        for (Item item : items) {
            memTracker.delete(item.getId());
        }
        return items.isEmpty();
    }
}
