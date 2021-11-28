package ru.job4j.function;

import java.util.*;
import java.util.function.Function;

public class FunctionDiapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
