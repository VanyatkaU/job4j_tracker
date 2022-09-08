package ru.job4j.tracker.gc;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.model.Item;

public class UserActonAdd implements UserAction {

    private final Output out;

    public UserActonAdd(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Add many Items ====");
        int quantity = Integer.parseInt(input.askStr("Enter quantity: "));
        for (int i = 0; i < quantity; i++) {
            Item item = new Item(quantity);
            memTracker.add(item);
        }
        return true;
    }
}
