/*
A simple programme to demonstrate overloading Java methods
 */

package com.EirScientific;

public class Main {

    public static void main(String[] args) {
    	int myfeet = 2;
    	int myinch = 13;
    	int myinch2 = 1;
    	double myCentimetre = calFeetInch2Centimetre(myfeet, myinch);
		System.out.println(myCentimetre + "cm");

		System.out.println(calFeetInch2Centimetre(myinch2) + "cm");
	}

    public static double calFeetInch2Centimetre(double numFeet, double numInch)
	{
		/*
		a method using 2 parameters, Feet and Inch
		 */
		double numCentimetre = 0;

		// parameters validation
		if (numFeet < 0 || numInch < 0)
		{
			System.out.println("Invalid parameter: measurement reading cannot be negative");
		}
		else
		{
			// validate feet and inch
			if (numInch >= 12)
			{
				numFeet += numInch / 12;
				numInch = numInch % 12;
			}
			double ft2cmConvert = 30.48;
			double in2cmConvert = 2.54;
			numCentimetre += numFeet * ft2cmConvert;
			numCentimetre += numInch * in2cmConvert;
		}
		return numCentimetre;
	}

	public static double calFeetInch2Centimetre(double numInch)
	{
		/*
		a method using 1 parameter, Inch
		 */
		double numCentimetre = 0;
		if (numInch < 0)
		{
			System.out.println("Invalid parameter: measurement reading cannot be negative");
		}
		else
		{
			double in2cmConversion = 2.54;
			numCentimetre += numInch * in2cmConversion;
		}
		return numCentimetre;
	}
}
