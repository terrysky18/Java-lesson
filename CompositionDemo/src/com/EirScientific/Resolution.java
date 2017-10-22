package com.EirScientific;

/**
 * Created by Terry Song on 22/10/2017.
 */
public class Resolution {
	private int pixel_width;
	private int pixel_height;

	public Resolution(int pixel_width, int pixel_height) {
		this.pixel_width = pixel_width;
		this.pixel_height = pixel_height;
	}

	public int getPixel_width() {
		return pixel_width;
	}

	public void setPixel_width(int pixel_width) {
		this.pixel_width = pixel_width;
	}

	public int getPixel_height() {
		return pixel_height;
	}

	public void setPixel_height(int pixel_height) {
		this.pixel_height = pixel_height;
	}
}
