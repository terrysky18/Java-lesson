package com.EirScientific;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	/* Linear congruential random number generator
    	Park/Miller suggestion:  a=16807, m=2147483647, c=0 for 32-bit signed integer
    	 */
    	int a = 16807;
    	int m = 2147483647;
    	int c = 0;

		ArrayList<Integer> x_array = new ArrayList<Integer>();

		int q = m / a;
		int r = m % a;
		// seed the random number sequence
		x_array.add(100);
		for (int idx=0; idx<25; idx++)
		{
			int element = a * (x_array.get(idx) - x_array.get(idx) / q) * q - r * (x_array.get(idx) / q);
			// next element
			x_array.add(element);
			System.out.println(x_array.get(idx));
		}
    }
}
