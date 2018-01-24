package com.EirScientific;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The class uses Reentrant Lock to prevent thread interference
 */
public class NewConsumer implements Runnable {

	private List<String> buffer;
	private String colour;
	private ReentrantLock bufferLock;

	public NewConsumer(List<String> buffer, String colour, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.colour = colour;
		this.bufferLock = bufferLock;
	}

	public void run() {
		int counter = 0;

		while (true) {
			// Only execute if tryLock is true
			if (bufferLock.tryLock()) {
				try {
					if (buffer.isEmpty()) {
						continue;
					}
					System.out.println(colour + "Counter = " + counter);
					counter = 0;

					if (buffer.get(0).equals(Main.EOF)) {
						// End of buffer
						System.out.println(colour + "Exiting");
						// Stop the loop
						break;
					} else {
						// Remove buffer element after reading it
						System.out.println(colour + "Consumed " + buffer.remove(0));
					}
				} finally {
					// Always release the lock no matter
					bufferLock.unlock();
				}
			}
			else {
				counter++;
			}
		}
	}
}
