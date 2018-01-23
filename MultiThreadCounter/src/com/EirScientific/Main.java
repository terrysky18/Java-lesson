package com.EirScientific;

public class Main {

    public static void main(String[] args) {
		Countdown countdown = new Countdown();

    	CountDownThread t1 = new CountDownThread(countdown);
		t1.setName("Thread 1");

		CountDownThread t2 = new CountDownThread(countdown);
		t2.setName("Thread 2");

		t1.start();
		t2.start();
    }
}

class Countdown {
	// instance variable is stored on the Heap, shared by threads
	// shows race condition
	private int k = 10;

	public void doCountDown() {
		String colour;

		switch (Thread.currentThread().getName()) {
			case "Thread 1":
				colour = ThreadColour.ANSI_CYAN;
				break;

			case "Thread 2":
				colour = ThreadColour.ANSI_PURPLE;
				break;

			default:
				colour = ThreadColour.ANSI_REST;
		}

		// Synchronisation prevents race condition
		// a block is synchronised, minimum synchronisation is desired
		synchronized (this) {
			for (int i = 10; i > 0; i--) {
				// i is a local variable, it's stored on the thread stack
				System.out.println(colour + Thread.currentThread().getName() + ": i=" + i + "; k=" + k);
				System.out.println("");
				k--;
			}
		}
	}
}

class CountDownThread extends Thread {
	private Countdown threadCountdown;

	public CountDownThread(Countdown countdown) {
		threadCountdown = countdown;
	}

	public void run() {
		threadCountdown.doCountDown();
	}
}
