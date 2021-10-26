package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = Integer.parseInt(input.askStr("Enter menu:"));
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("1", "6", "2", "0")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected1 = Integer.parseInt(input.askStr("Enter menu:"));
        int selected6 = Integer.parseInt(input.askStr("Enter menu:"));
        int selected2 = Integer.parseInt(input.askStr("Enter menu:"));
        int selected0 = Integer.parseInt(input.askStr("Enter menu:"));
        assertThat(selected1, is(1));
        assertThat(selected6, is(6));
        assertThat(selected2, is(2));
        assertThat(selected0, is(0));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = Integer.parseInt(input.askStr("Enter menu:"));
        assertThat(selected, is(-1));
    }
}