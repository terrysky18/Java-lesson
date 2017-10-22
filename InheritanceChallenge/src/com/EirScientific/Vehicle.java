package com.EirScientific;

/**
 * Created by Terry Song on 10/10/2017.
 */
public class Vehicle {

	/* String vehicle_type, (Lorry, Bus, Van, Car) */
	private String vehicle_type;
	/* int wheels, number of wheels */
	private int wheels;
	/* double weight, weight of vehicle */
	private double weight;
	/* String gearbox, one of (Manual, Automatic, Dual-clutch) */
	private String gearbox;
	/* double mileage, mileage of vehicle in km */
	private double mileage;
	/* double emission_rate, CO2 emission in gram/km */
	private double emission_rate;
	/* int doors, number of doors */
	private int doors;
	/* int wheelbase, wheelbase dimension */
	private int wheelbase;
	/* int length, length of the vehicle */
	private int length;
	/* int width, width of the vehicle */
	private int width;
	/* int height, height of the vehicle */
	private int height;

	/* Default Constructor */
	public Vehicle() {
		this.vehicle_type = "undefined";
		this.wheels = -1;
		this.weight = -1;
		this.gearbox = "unknown";
		this.mileage = -1;
		this.emission_rate = -1;
		this.doors = -1;
		this.wheelbase = -1;
		this.length = -1;
		this.width = -1;
		this.height = -1;
	}

	public Vehicle(String vehicle_type,
			int wheels,
			double weight,
			String gearbox,
			double mileage,
			double emission_rate,
			int doors,
			int wheelbase,
			int length,
			int width,
			int height)
	{
		this.vehicle_type = vehicle_type;
		this.wheels = wheels;
		this.weight = weight;
		this.gearbox = gearbox;
		this.mileage = mileage;
		this.emission_rate = emission_rate;
		this.doors = doors;
		this.wheelbase = wheelbase;
		this.length = length;
		this.width = width;
		this.height = height;
	}
}
