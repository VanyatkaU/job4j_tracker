package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>(List.of(1, 2, -3, -4, 5, -6, 7, -8, 9));
        List<Integer> nums = num.stream().
                filter(n -> (n > 0)).collect(Collectors.toList());
        nums.forEach(System.out::println);
    }
}
