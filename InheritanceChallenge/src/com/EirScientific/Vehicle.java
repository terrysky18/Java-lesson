package com.EirScientific;

/**
 * Created by Terry Song on 10/10/2017.
 */
public class Vehicle {

	/* String vehicle_type, one of
	[Lorry, Bus, Van, Car] */
	private String vehicle_type;

	/* int wheels, number of wheels */
	private int wheels;

	/* double weight, weight of vehicle */
	private double weight;

	/* String gearbox, one of [Manual, Automatic] */
	private String gearbox;

	/* double mileage, mileage of vehicle in km */
	private double mileage;

	/* int purchase_year, year of purchase */
	private int purchase_year;

	/* double emission_rate, CO2 emission in gram/km */
	private double emission_rate;

	/* Default Constructor */
	public Vehicle() {
		this.vehicle_type = "undefined";
		this.wheels = 0;
		this.weight = 0;
		this.gearbox = "unknown";
		this.mileage = 0;
		this.purchase_year = 0;
		this.emission_rate = 0;
	}

	public Vehicle(String vehicle_type, int wheels, double weight, String gearbox, double mileage, int purchase_year, double emission_rate)
	{
		this.vehicle_type = vehicle_type;
		this.wheels = wheels;
		this.weight = weight;
		this.gearbox = gearbox;
		this.mileage = mileage;
		this.purchase_year = purchase_year;
		this.emission_rate = emission_rate;
	}
}
