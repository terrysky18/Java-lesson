package com.EirScientific;

import java.util.Random;

/**
 * Producer class
 */
public class Writer implements Runnable {

	private Message message;

	public Writer (Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String messages[] = {
				"Humpty Dumpty sat on a wall",
				"Humpty Dumpty had a great fall",
				"All the king's horses and all the king's men",
				"Couldn't put Humpty together again"
		};
		Random rand = new Random();

		for (int i=0; i<messages.length; i++) {
			message.write(messages[i]);
			try {
				// Randomly sleep maximum of 2 sec after writing a message
				Thread.sleep(rand.nextInt(2000));
			} catch (InterruptedException e) {

			}
		}
		message.write("Finished");
	}
}
