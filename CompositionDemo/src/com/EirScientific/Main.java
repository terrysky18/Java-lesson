package com.EirScientific;

/*
A simple demonstration of the use of composition in Java
 */
public class Main {

    public static void main(String[] args) {
		Dimensions caseDimension = new Dimensions(20, 25, 5);
		Case theCase = new Case("220B", "Dell", "240", caseDimension);

		Monitor theMonitor = new Monitor("27in Beast", "Acer", 27, new Resolution(2540, 1440));

		Motherboard motherboard = new Motherboard("BJ-201", "Asus", 8, 6, "v2.44");

		PersonalComputer myPC = new PersonalComputer(theCase, theMonitor, motherboard);

		/* Use getter function to access class function */
		myPC.getMonitor().drawPixel(1500, 250, "green");
		myPC.getMotherboard().loadProgramme("Windows 9.9");
		myPC.getTheCase().pressPowerButton();
    }
}
