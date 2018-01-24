package com.EirScientific;

import javax.swing.text.html.ListView;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The class uses Reentrant Lock to prevent interference
 */
public class NewProducer implements Runnable {

	private List<String> buffer;
	private String colour;
	private ReentrantLock bufferLock;

	public NewProducer(List<String> buffer, String colour, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.colour = colour;
		this.bufferLock = bufferLock;
	}

	public void run() {
		Random rand = new Random();
		String[] nums = {"18", "19", "20", "21", "22", "23", "24", "25"};

		for (String num: nums) {
			try {
				System.out.println(colour + "Add..." + num);
				// Lock thread buffer
				bufferLock.lock();
				try {
					buffer.add(num);
				} finally {
					// Always unlock thread buffer
					bufferLock.unlock();
				}

				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println("Producer thread interrupted");
			}
		}
		System.out.println(colour + "Adding EOF and exiting...");
		bufferLock.lock();
		try {
			buffer.add("EOF");
		} finally {
			bufferLock.unlock();
		}
	}
}
