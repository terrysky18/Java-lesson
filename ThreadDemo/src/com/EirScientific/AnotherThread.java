package com.EirScientific;

import static com.EirScientific.ThreadColour.ANSI_BLUE;

public class AnotherThread extends Thread {

	@Override
	public void run() {
		System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

		// Put the thread to sleep
		try {
			Thread.sleep(4000);		// sleep for 4 seconds
		} catch (InterruptedException e) {
			System.out.println(ANSI_BLUE + "Different thread wakes up " + currentThread().getName());
			return;		// terminate the thread
		}

		System.out.println(ANSI_BLUE + "Four seconds passes " + currentThread().getName() + " wakes up");
	}
}
