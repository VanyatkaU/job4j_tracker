package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Suit {
    Diamonds, Hearts, Spades, Clubs;

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
