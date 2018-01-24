package com.EirScientific;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrate Java Util thread package
 */
public class Main {

	public static final String EOF = "EOF";

    public static void main(String[] args) {
    	// Using synchronisation to prevent thread interference
    	// ArrayList is NOT thread safe, needs synchronisation
		List<String> buffer = new ArrayList<>();

		/*
		MyProducer producer = new MyProducer(buffer, ThreadColour.ANSI_YELLOW);
		MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_PURPLE);
		MyConsumer consumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN);

		// new Thread(Runnable).start()
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		*/

		// Using ReentrantLock to prevent thread interference
		ReentrantLock threadLock = new ReentrantLock();
		NewProducer new_producer = new NewProducer(buffer, ThreadColour.ANSI_YELLOW, threadLock);
		NewConsumer new_consumer1 = new NewConsumer(buffer, ThreadColour.ANSI_PURPLE, threadLock);
		NewConsumer new_consumer2 = new NewConsumer(buffer, ThreadColour.ANSI_CYAN, threadLock);

		new Thread(new_producer).start();
		new Thread(new_consumer1).start();
		new Thread(new_consumer2).start();

    }
}
