package com.EirScientific;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Lister {

	private ArrayList<String> my_list;

	public Lister() {
		my_list = new ArrayList<String>();
	}

	public void makeList() {
		Random rand = new Random();
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
		my_list.add(Double.toString(rand.nextGaussian()));
	}

	public void removeNegative() {
		ArrayList<String> new_list = new ArrayList<>();
		for (String elem : my_list) {
			double element = Double.parseDouble(elem);
			if (element > 0.0) {
				new_list.add(elem);
			}
		}
		my_list = new_list;
	}

	@Override
	public String toString() {
		String my_string = "my_list = {\n";
		for (String elem : my_list) {
			my_string += elem;
			my_string += "\n";
		}
		my_string += "}";
		return my_string;
	}
}
