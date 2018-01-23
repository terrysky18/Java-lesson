package com.EirScientific.OdeonCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilmReview {

    private LocalDateTime review_date_time;
    private int rating;
    private String review;

    public FilmReview() {
        this.review_date_time = LocalDateTime.now();
        this.rating = 0;
        this.review = null;
    }

    public FilmReview(LocalDateTime review_date_time, int rating, String review) {
        this.review_date_time = review_date_time;
        this.rating = rating;
        this.review = review;
    }

    @Override
	public String toString()
	{
		DateTimeFormatter dt_formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
    	String purchase_dt = this.review_date_time.format(dt_formatter);
		String film_review = "Received on: " + purchase_dt;
		film_review += "\nRating: ";
		film_review += Integer.toString(this.rating);
		film_review += "\nReview: ";
		film_review += this.review;
		return film_review;
	}

    public LocalDateTime getReviewDateTime() {
        return review_date_time;
    }

    public LocalDate getReviewDate() {
        return review_date_time.toLocalDate();
    }

    public void setReviewDate(LocalDateTime review_date) {
        this.review_date_time = review_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
