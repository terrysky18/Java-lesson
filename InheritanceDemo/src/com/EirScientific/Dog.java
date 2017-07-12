package com.EirScientific;

/**
 * Created by Terry Song on 10/07/2017.
 *
 * An extended class object to show class inheritance
 */
public class Dog extends Animal {
	// use key word, extends

	/* member variables specific to Dog class */
	private int eyes;
	private int legs;
	private int tail;
	private int teeth;
	private String coat;

	/* Constructors */
	public Dog()
	{
		/* Default constructor */
		super();
	}

	public Dog(String name, int brain, int body, double size, double weight)
	{
		// key word, super: call the constructor of the base class
		super(name, brain, body, size, weight);
	}

	public Dog(int eyes, int legs, int tail, int teeth, String coat,
			   String name, int brain, int body, double size, double weight)
	{
		super(name, brain, body, size, weight);
		this.eyes = eyes;
		this.legs = legs;
		this.tail = tail;
		this.teeth = teeth;
		this.coat = coat;
	}

	public void ChewFood()
	{
		System.out.println(this.getName() + " is chewing food");
	}

	/* override a base class method */
	@Override
	public void Eat()
	{
		this.ChewFood();
		// super.Eat() calls the Animal class function
		super.Eat();
	}
}
