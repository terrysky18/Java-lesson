package com.EirScientific;

import java.util.ArrayList;

/**
 * Created by Terry Song on 10/10/2017.
 */
public class Car extends Vehicle {

    /* String car_type, (coupe, saloon, estate, roadster, racer) */
    private String car_type;
    /* String manufacturer */
    private String manufacturer;
    /* double fuel_capacity */
    private double fuel_capacity;
    /* String engine_type, (electric, petrol-electric, diesel, V6-petrol, V8-petrol, V12-petrol) */
    private String engine_type;
    /* String engine_layout */
    private String engine_layout;
    /* String model, model of the car */
    private String model;
    /* int[] production_years, years in production */
    private ArrayList<Integer> production_years;

    public Car() {
		super("car", 4, -1, "unknown", -1, -1, 2, -1, -1, -1, -1);
    	this.car_type = "";
        this.manufacturer = "";
        this.fuel_capacity = -1;
        this.engine_type = "";
        this.engine_layout = "";
        this.model = "";
        this.production_years = new ArrayList<Integer>();
        this.production_years.add(-1);
    }

    public Car(String car_type, String manufacturer, double fuel_capacity, String engine_type, String engine_layout, String model, ArrayList<Integer> production_years) {
		super("car", 4, -1, "unknown", -1, -1, 2, -1, -1, -1, -1);
    	this.car_type = car_type;
        this.manufacturer = manufacturer;
        this.fuel_capacity = fuel_capacity;
        this.engine_type = engine_type;
        this.engine_layout = engine_layout;
        this.model = model;
        this.production_years = production_years;
    }

    public Car(String vehicle_type, int wheels, double weight, String gearbox, double mileage, double emission_rate, int doors, int wheelbase, int length, int width, int height,
			   String car_type, String manufacturer, double fuel_capacity, String engine_type, String engine_layout, String model, ArrayList<Integer> production_years)
	{
		super(vehicle_type, wheels, weight, gearbox, mileage, emission_rate, doors, wheelbase, length, width, height);
		this.car_type = car_type;
		this.manufacturer = manufacturer;
		this.fuel_capacity = fuel_capacity;
		this.engine_type = engine_type;
		this.engine_layout = engine_layout;
		this.model = model;
		this.production_years = production_years;
	}
}