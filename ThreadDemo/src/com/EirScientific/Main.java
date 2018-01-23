package com.EirScientific;

import static com.EirScientific.ThreadColour.ANSI_PURPLE;
import static com.EirScientific.ThreadColour.ANSI_RED;
import static com.EirScientific.ThreadColour.ANSI_REST;

public class Main {

    public static void main(String[] args) {
	    System.out.println(ANSI_PURPLE + "Hello from MAIN thread.");

	    // New thread instantiated with named class
	    Thread anotherThread = new AnotherThread();
	    anotherThread.setName("== Another Thread ==");
	    // Start the new thread
	    anotherThread.start();

	    // New thread with anonymous class
		new Thread() {
			public void run() {
				System.out.println(ANSI_RED + "Hello from ANONYMOUS thread.");
			}
		}.start();

		// New thread using Runnable
		Thread myRunnableThread = new Thread(new MyRunnable());
		myRunnableThread.start();

		// New thread with anonymous Runnable
		Thread anotherRunnable = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println(ANSI_REST + "Anonymous runnable thread.");

				try {
					// Wait for anotherThread to terminate then continue
					anotherThread.join(2000);	// join a thread, 2 seconds timeout
					System.out.printf(ANSI_REST + "AnotherThread terminated or timed out, I'm running again");
				} catch (InterruptedException e) {
					System.out.println(ANSI_REST + "Couldn't wait.  I am interruprted.");
				}
			}
		});
		anotherRunnable.start();

		// Interrupt a thread
		//anotherThread.interrupt();

	    System.out.println(ANSI_PURPLE + "Second hello from MAIN thread");
    }
}
