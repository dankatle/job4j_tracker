package ru.job4j.poly;

public class Bus implements Transport {
    private double fuel;
    private int passengars;

    @Override
    public void drive() {
        System.out.println("Go-go-go!");
    }

    @Override
    public void passengars(int amount) {
        passengars += amount;
    }

    @Override
    public double refuel(double amount) {
        return fuel + amount;
    }
}
