package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Found item"));
        FindByNameAction findByNameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Found item");

        findByNameAction.execute(input, memTracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln + item + ln));
        assertThat(memTracker.findById(1).getName(), is("Found item"));
    }

    @Test
    public void whenNotFindByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        String foundName = "Item found by name";
        FindByNameAction findByNameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(foundName);

        findByNameAction.execute(input, memTracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "Заявки с именем: " + foundName + " не найдены." + ln));
    }

}