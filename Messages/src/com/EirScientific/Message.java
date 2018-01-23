package com.EirScientific;

/**
 * Demonstrate Producer and Consumer in Java
 */
public class Message {

	private String message;
	private boolean empty = true;

	public synchronized String read() {
		while (empty) {
			// Read the message when empty
			try {
				// Suspend the thread lock
				// always call wait() in a loop
				wait();
			} catch (InterruptedException e) {
				System.out.println("message read interrupted");
			}
		}
		empty = true;
		notifyAll();	// notify all threads
		return message;
	}

	public synchronized void write(String message) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("message write interrupted");
			}
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}
