package com.EirScientific;

/**
 * Created by Terry Song on 10/07/2017.
 *
 * Base class object to demonstrate the use of inheritance
 */
public class Animal {
	/* member variables, fields */
	private String name;
	private int brain;
	private int body;
	private double size;
	private double weight;

	/* Constructors */
	public Animal()
	{
		// Default constructor
		this.name = "undefined";
		this.brain = 0;
		this.body = 0;
		this.size = 0;
		this.weight = 0;
	}

	public Animal(String name, int brain, int body, double size, double weight)
	{
		this.name = name;
		this.brain = brain;
		this.body = body;
		this.size = size;
		this.weight = weight;
	}

	/* member functions, methods */
	public String getName() {
		return this.name;
	}

	public int getBrain() {
		return this.brain;
	}

	public int getBody() {
		return this.body;
	}

	public double getSize() {
		return this.size;
	}

	public double getWeight() {
		return this.weight;
	}

	public void Eat()
	{
		System.out.println(this.name + " is eating");
	}

	public void Move()
	{
		System.out.println(this.name + " is moving");
	}
}
