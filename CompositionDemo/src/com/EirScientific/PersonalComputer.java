package com.EirScientific;

/**
 * Created by Terry Song on 22/10/2017.
 */
public class PersonalComputer {
	private Case theCase;
	private Monitor monitor;
	private Motherboard motherboard;

	public PersonalComputer(Case theCase, Monitor monitor, Motherboard motherboard) {
		this.theCase = theCase;
		this.monitor = monitor;
		this.motherboard = motherboard;
	}

	public Case getTheCase() {
		return theCase;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}
}
