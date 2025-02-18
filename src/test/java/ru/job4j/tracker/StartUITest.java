package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Input in = new StubInput(
                Arrays.asList("0", "Item name", "1")
        );
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Test1"));
        String replacedName = "New Test name";
        Input in = new StubInput(
                Arrays.asList("0", (String.valueOf(one.getId())), replacedName, "1")
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка успешно изменена." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                Arrays.asList("0", (String.valueOf(item.getId())), "1")
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Test1"));
        Input in = new StubInput(
                Arrays.asList("0", "1")
        );
        List<UserAction> actions = Arrays.asList(
                new ShowAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Test1"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(one.getName()), "1")
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("Test1"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(one.getId()), "1")
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new Exit()
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Input in = new StubInput(
                List.of("0")
        );
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("7", "0")
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                )
        );
    }
}