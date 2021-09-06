package ru.job4j.oop;

public class Battery {
    private int load;
    public Battery(int load) {
        this.load = load;
    }
    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(23);
        Battery second = new Battery(56);
        System.out.println("First battery: " + first.load + " Second battery: " + second.load);
        first.exchange(second);
        System.out.println("First battery: " + first.load + " Second battery: " + second.load);
    }
}