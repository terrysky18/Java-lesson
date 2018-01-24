package com.EirScientific;

import java.util.List;
import java.util.Random;

/**
 * The class uses synchronisation to prevent thread interference
 */
public class MyProducer implements Runnable {

	private List<String> buffer;
	private String colour;

	public MyProducer(List<String> buffer, String colour) {
		this.buffer = buffer;
		this.colour = colour;
	}

	public void run() {
		Random rand = new Random();
		String[] nums = {"1", "2", "3", "4", "5"};

		for (String num: nums) {
			try {
				System.out.println(colour + "Adding..." + num);
				synchronized (buffer) {
					// Fill the buffer
					buffer.add(num);
				}
				// Then randomly sleep a bit
				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.printf("Producer thread interrupted");
			}
		}
		System.out.println(colour + "Adding EOF and exiting...");
		synchronized (buffer) {
			buffer.add("EOF");
		}
	}
}
