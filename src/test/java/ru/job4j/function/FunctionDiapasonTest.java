package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(3, 6, x -> x * x);
        List<Double> expected = Arrays.asList(9D, 16D, 25D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenExponentialResults() {
        FunctionDiapason function = new FunctionDiapason();
        List<Double> result = function.diapason(4, 7, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(16D, 32D, 64D);
        assertThat(result, is(expected));
    }
}