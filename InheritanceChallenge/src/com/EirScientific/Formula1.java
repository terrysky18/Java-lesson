package com.EirScientific;

import java.util.ArrayList;

/**
 * Created by Terry Song on 10/10/2017.
 */
public class Formula1 extends Car {

    /* String team */
    private String team;
    /* String tyres, tyre manufacturer */
    private String tyres;
    /* String engine_supplier */
    private String engine_supplier;
    /* String[] drivers, team drivers during a specific season */
    private ArrayList<String> drivers;

    public Formula1()
    {
    	super("racer", "unknown", -1, "unknown", "unknown", "unknown", new ArrayList<Integer>());
    	this.team = "";
    	this.tyres = "";
    	this.engine_supplier = "";
    	this.drivers = new ArrayList<String>();
    	this.drivers.add("driver1");
    	this.drivers.add("driver2");
    }

    public Formula1(String team, String tyres, String engine_supplier, String driver1, String driver2)
	{
		super("racer", team, -1, "unknown", "unknown", "unknown", new ArrayList<Integer>());
		this.team = team;
		this.tyres = tyres;
		this.engine_supplier = engine_supplier;
		this.drivers = new ArrayList<String>();
		this.drivers.add(driver1);
		this.drivers.add(driver2);
	}

	public void setDrivers(String driver1, String driver2)
	{
		this.drivers.set(0, driver1);
		this.drivers.set(1, driver2);
	}

	public String getDrivers()
	{
		String raceDriver = "Drivers: ";
		raceDriver += drivers.toString();
		return raceDriver;
	}
}
