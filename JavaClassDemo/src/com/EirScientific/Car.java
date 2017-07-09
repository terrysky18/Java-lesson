package com.EirScientific;

/**
 * Created by Terry Song on 08/07/2017.
 */
public class Car {

	/* member variables, state components */
	private int doors;
	private int wheels;
	private String model;
	private String engine;
	private String colour;

	public void SetDoors(int doors)
	{
		this.doors = doors;
	}

	public void SetWheels(int wheels)
	{
		this.wheels = wheels;
	}

	public void SetModel(String model)
	{
		String validModel = model.toLowerCase();

		// validation test
		if (validModel.equals("carrera gt") || validModel.equals("commodore"))
		{
			this.model = model;
		}
		else
		{
			this.model = "Unknown";
		}
	}

	public void SetEngine(String engine)
	{
		this.engine = engine;
	}

	public void SetColour(String colour)
	{
		this.colour = colour;
	}

	public int GetDoors()
	{
		return this.doors;
	}

	public int GetWheels()
	{
		return this.wheels;
	}

	public String GetModel()
	{
		return this.model;
	}

	public String GetEngine()
	{
		return this.engine;
	}

	public String GetColour()
	{
		return this.colour;
	}
}
