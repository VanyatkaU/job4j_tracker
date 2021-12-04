package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void matrixSquare() {
        Integer[][] matrix = new Integer[][]{{1, 2}, {3, 4}};
        List<Integer> rsl = Matrix.matrixConvert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void matrixNotSquare() {
        Integer[][] matrix = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        List<Integer> rsl = Matrix.matrixConvert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}
