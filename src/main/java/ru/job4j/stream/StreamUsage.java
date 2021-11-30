package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(
                1, -2, 3, 4, -5, -6, 7, -8, 9));
        ArrayList<Integer> num = (ArrayList<Integer>) nums.stream().
                filter(i -> (i > 0)).collect(Collectors.toList());
        num.forEach(System.out::println);
    }
}

