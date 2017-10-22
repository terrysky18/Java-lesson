package com.EirScientific;

/**
 * Created by Terry Song on 22/10/2017.
 */
public class Monitor {
	private String model;
	private String manufacturer;
	private int diagonal;
	private Resolution nativeResolution;

	public Monitor(String model, String manufacturer, int diagonal, Resolution nativeResolution) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.diagonal = diagonal;
		this.nativeResolution = nativeResolution;
	}

	public void drawPixel(int x, int y, String colour)
	{
		System.out.println("Drawing pixel at " + x + ", " + y + " in colour " + colour);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}

	public Resolution getNativeResolution() {
		return nativeResolution;
	}

	public void setNativeResolution(Resolution nativeResolution) {
		this.nativeResolution = nativeResolution;
	}
}
