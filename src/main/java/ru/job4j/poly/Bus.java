package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по трассам.");
    }

    @Override
    public void speed() {
        System.out.println("Максимальная скорость составляет 110 км/ч.");
    }
}
