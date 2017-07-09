package com.EirScientific;

public class Main {

    public static void main(String[] args) {
    	/* width of int = 32, 4 bytes */
    	int my_int_val = 11 / 2;

    	/* width of float = 32, 4 bytes */
    	float my_float_val = 11f / 2;

    	/* width of double = 64, 8 bytes */
    	double my_double_val = 11d / 2;

		System.out.println("int value = " + my_int_val);
		System.out.println("float value = " + my_float_val);
		System.out.println("double value = " + my_double_val);

		/* pound to kilgram */
		double pound2kg = 0.45359237;	// 0.45 kg in 1 pound
		double numPound = 155d;			// 155 pounds

		double inKg = numPound * pound2kg;
		System.out.println("my weight = " + inKg);
	}
}
