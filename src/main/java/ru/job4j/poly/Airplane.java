package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху.");
    }

    @Override
    public void speed() {
        System.out.println("Максимальная скорость составляет 950 км/ч.");
    }
}
