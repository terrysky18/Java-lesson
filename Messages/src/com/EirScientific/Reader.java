package com.EirScientific;

import java.util.Random;

/**
 * Consumer class
 */
public class Reader implements Runnable {

	private Message message;

	public Reader(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		Random rand = new Random();
		for (String latestMessage=message.read(); !latestMessage.equals("Finished"); latestMessage=message.read()) {
			System.out.println(latestMessage);
			try {
				// Randomly sleep after reading a message
				Thread.sleep(rand.nextInt(2000));
			} catch (InterruptedException e) {

			}
		}
	}
}
