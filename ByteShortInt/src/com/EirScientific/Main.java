package com.EirScientific;

public class Main {

    public static void main(String[] args) {
		System.out.println("Yes!");

		/* integer limits, width = 32 */
		int my_min_value = -2147483648;
		int my_max_value = 2147483647;
		int calInt = (my_max_value + my_min_value + 2);
		System.out.println(calInt);

		/* byte values, width = 8 */
		byte my_byte_minVal = -128;
		byte my_byte_maxVal = 127;
		/* cast in Java */
		byte calByte = (byte)(my_byte_minVal/2);
		System.out.println(calByte);

		/* short values, width = 16 */
		short my_short_minVal = -32768;
		short my_short_maxVal = 32767;
		short my_short_val = (short)((my_short_maxVal + my_short_minVal)*2);
		System.out.println(my_short_val);

		/* long values, width = 64*/
		long my_long_minVal = -9_223_372_036_854_775_808L;
		long my_long_maxVal = 9_223_372_036_854_775_807L;
		long my_long_val = (my_long_maxVal/2);
		System.out.println(my_long_val);

		/* add them all up */
		int val1 = 320;
		short val2 = 160;
		byte val3 = 80;

		long total_val = 56000L + ((val1 + val2 + val3)*100L);
		System.out.println("final total = " + total_val);
	}
}
