package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Осторожно! Автобус отправляется.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Автобус вмещает " + number + " пассажиров.");
    }

    @Override
    public double refuel(double fuelQuantity) {
        return fuelQuantity * 51.36;
    }
}
