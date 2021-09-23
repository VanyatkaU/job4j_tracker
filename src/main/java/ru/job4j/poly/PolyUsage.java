package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplain = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{airplain, train, bus};
        for (Vehicle v : vehicles) {
            v.move();
            v.speed();
        }
    }
}
