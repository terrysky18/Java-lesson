package com.EirScientific;

public class Main {

    public static void main(String[] args) {
	// write your code here
		Animal myAnimal = new Animal("animal", 1, 1, 5.0, 5.0);

		Dog myDog = new Dog(2, 4, 1, 18, "long silky", "Sparky", 1, 1, 8.6, 3.7);

		myDog.Eat();
		myDog.Move();

		//myDog.ChewFood();
    }
}
