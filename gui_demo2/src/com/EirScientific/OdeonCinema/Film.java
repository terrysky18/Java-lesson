package com.EirScientific.OdeonCinema;

/**
 * Film.java
 * Film class:  Contains information about a film being shown in cinema
 */

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Film {

    private String film_name;
    private double avg_rating;
    private double total_income;
    private int total_spectators;
    private ArrayList<FilmReview> customer_reviews;

    public Film() {
        this.film_name = "";
        this.avg_rating = 0.0;
        this.total_income = 0.0;
        this.total_spectators = 0;
        this.customer_reviews = new ArrayList<FilmReview>();
    }

    public Film(String film_name) {
        this.film_name = film_name;
        this.avg_rating = 0.0;
        this.total_income = 0.0;
        this.total_spectators = 0;
        this.customer_reviews = new ArrayList<FilmReview>();
    }

    @Override
	public String toString()
	{
		String film_info = this.film_name;
		film_info += "\nAverage Rating: ";
		film_info += Double.toString(this.avg_rating);
		film_info += "\nTotal Income: ";
		film_info += Double.toString(this.total_income);
		film_info += "\nTotal Spectator: ";
		film_info += Integer.toString(this.total_spectators);
		film_info += "\nNumber of reviews: ";
		film_info += Integer.toString(customer_reviews.size());
		return film_info;
	}

    public void addSpectator() { this.total_spectators++; }

    public void removeSpectator() {
    	if (total_spectators > 0) { this.total_spectators--; }
	}

    public int getTotalSpectator() { return total_spectators; }

    public String getFilmName() {
        return film_name;
    }

    public void setFilmName(String film_name) {
        this.film_name = film_name;
    }

    public void addIncome(double ticket_price)
	{
		total_income += ticket_price;
	}

	public void reduceIncome(double ticket_price) {
    	if (this.total_income > 0.0) { total_income -= ticket_price; }
    }

	public double getTotalIncome() { return total_income; }

	public double getAvgRating() {
        this.updateAvgRating();
        return avg_rating;
    }

    /**
     * Overloaded function
     * Add a FilmReview object to the customer reviews ArrayList
     * @param customer_review
     */
	public void addCustomerReview(FilmReview customer_review) {
        this.customer_reviews.add(customer_review);
        this.updateAvgRating();
    }

    /**
     * Overloaded function
     * Add a FilmReview object to with current time stamp to review ArrayList
     * @param rating
     * @param review
     */
    public void addCustomerReview(int rating, String review) {
        LocalDateTime current_time = LocalDateTime.now();
        FilmReview customer_review = new FilmReview(current_time, rating, review);
        this.customer_reviews.add(customer_review);
        this.updateAvgRating();
    }

    /**
     * Send the latest review
     * send a null object when no review has been saved
     * @return FilmReview
     */
    public FilmReview getLastReview() {
        if (this.customer_reviews.size() > 0) {
            return customer_reviews.get(customer_reviews.size() - 1);
        }
        else { return null; }
    }

    /**
     * Send all reviews in the ArrayList
     * send a null object when no review has benn saved
     * @return ArrayList<FilmReview>
     */
    public ArrayList<FilmReview> getAllReviews() {
        if (this.customer_reviews.size() > 0) {
           return customer_reviews;
        }
        else { return null; }
    }

    /**
     * Private function
     * calculate the average rating
     * @return  void
     */
    private void updateAvgRating() {
        double ratings = 0.0;
        if (customer_reviews.size() > 0) {
        	for (FilmReview review : customer_reviews) {
            	ratings += review.getRating();
        	}
        	this.avg_rating = ratings / customer_reviews.size();
		}
		else {
        	this.avg_rating = ratings;
		}
    }
}
