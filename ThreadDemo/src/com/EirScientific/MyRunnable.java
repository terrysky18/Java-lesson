package com.EirScientific;

import static com.EirScientific.ThreadColour.ANSI_GREEN;

/**
 * Use Runnable to create a thread
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(ANSI_GREEN + "Hello from Runnable implementation of run().");
	}
}
