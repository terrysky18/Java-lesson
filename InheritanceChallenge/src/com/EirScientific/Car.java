package com.EirScientific;

/**
 * Created by Terry Song on 10/10/2017.
 */
public class Car extends Vehicle {

    /* String car_type, (coupe, saloon, estate, roadster) */
    private String car_type;

    /* String manufacturer */
    private String manufacturer;

    /* double fuel_capacity */
    private double fuel_capacity;

    /* String engine_type, (petrol-electric, diesel, V6-petrol, V8-petrol, V12-petrol) */
    private String engine_type;

    /* String engine_layout */
    private String engine_layout;

    /* String model, model of the car */
    private String model;

    /* int[] production_years, years in production */
    private int[] production_years;

    public Car() {
    }

    public Car(String car_type, String manufacturer, double fuel_capacity, String engine_type, String engine_layout, String model, int[] production_years) {
        this.car_type = car_type;
        this.manufacturer = manufacturer;
        this.fuel_capacity = fuel_capacity;
        this.engine_type = engine_type;
        this.engine_layout = engine_layout;
        this.model = model;
        this.production_years = production_years;
    }
}