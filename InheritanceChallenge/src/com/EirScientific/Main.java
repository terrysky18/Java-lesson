package com.EirScientific;

public class Main {

    public static void main(String[] args) {
        Vehicle my_vehicle = new Vehicle();
        Car my_car = new Car();
        Formula1 my_racer = new Formula1();

        my_racer.setDrivers("Jenson Button", "Nico Roseberg");
        System.out.println(my_racer.getDrivers());
    }
}
