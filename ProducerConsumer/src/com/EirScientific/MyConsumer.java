package com.EirScientific;

import java.util.List;

/**
 * The class uses synchronisation to prevent thread interference
 */
public class MyConsumer implements Runnable {

	private List<String> buffer;
	private String colour;

	public MyConsumer(List<String> buffer, String colour) {
		this.buffer = buffer;
		this.colour = colour;
	}

	public void run() {
		while (true) {
			synchronized (buffer) {
				if (buffer.isEmpty()) {
					continue;
				}

				if (buffer.get(0).equals(Main.EOF)) {
					// End of buffer
					System.out.println(colour + "Exiting");
					// Stop the loop
					break;
				} else {
					// Remove buffer element after reading it
					System.out.println(colour + "Removed " + buffer.remove(0));
				}
			}
		}
	}
}
