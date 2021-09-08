package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(23);
        Battery another = new Battery(56);
        System.out.println("First battery: " + first.load + " Another battery: " + another.load);
        first.exchange(another);
        System.out.println("First battery: " + first.load + " Another battery: " + another.load);
    }
}
