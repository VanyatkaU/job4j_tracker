package ru.job4j.tracker.gc;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.model.Item;

import java.util.List;

public class FindAll implements UserAction {

    private final Output out;

    public FindAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find ALL Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find ALL Items ====");
        List<Item> items = memTracker.findAll();
        out.println(items);
        return true;
    }
}
