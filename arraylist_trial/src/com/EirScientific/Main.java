package com.EirScientific;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        /*Lister my_lister = new Lister();
        my_lister.makeList();

        System.out.println("Initial:");
        System.out.println(my_lister.toString());

        System.out.println("\n");
        System.out.println("After removal");

		my_lister.removeNegative();
		System.out.println(my_lister.toString());*/

		LocalDate date1 = LocalDate.of(2017, Month.NOVEMBER, 11);
		System.out.println(date1);
		LocalDate date2 = date1.plusDays(5);
		System.out.println(date2);
		System.out.println("");
		while (!date1.isAfter(date2)) {
			System.out.println(date1);
			System.out.println(date1.isBefore(date2));
			date1 = date1.plusDays(1);
		}
    }
}
