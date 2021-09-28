package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

  @Test
  public void whenCreateItem() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Input in = new StubInput(
              new String[] {"0", "Item name", "1"}
      );
      UserAction[] actions = {
              new CreateAction(out),
              new Exit()
      };
      new StartUI(out).init(in, tracker, actions);
      assertThat(tracker.findAll()[0].getName(), is("Item name"));
  }

  @Test
  public void whenReplaceItem() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Item item = tracker.add(new Item("Replaced item"));
      String replacedName = "New item name";
      Input in = new StubInput(
              new String[] {"0", (String.valueOf(item.getId())), replacedName, "1"}
      );
      UserAction[] actions = {
              new ReplaceAction(out),
              new Exit()
      };
      new StartUI(out).init(in, tracker, actions);
      String ln = System.lineSeparator();
      assertThat(out.toString(), is(
              "Menu." + ln
                      + "0. Replace item" + ln
                      + "1. Exit" + ln
                      + "=== Edit item ====" + ln
                      + "Menu." + ln
                      + "0. Replace item" + ln
                      + "1. Exit" + ln
      ));
  }

  @Test
  public void whenDeleteItem() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Item item = tracker.add(new Item("Deleted item"));
      Input in = new StubInput(
              new String[] {"0", (String.valueOf(item.getId())), "1"}
      );
      UserAction[] actions = {
              new DeleteAction(out),
              new Exit()
      };
      new StartUI(out).init(in, tracker, actions);
      assertThat(tracker.findById(item.getId()), is(nullValue()));
  }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0"}
        );
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ====" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "name", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find item by name ====" + ln
                        + "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ====" + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
        ));
    }
}