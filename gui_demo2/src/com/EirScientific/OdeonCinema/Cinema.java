package com.EirScientific.OdeonCinema;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cinema {

	private ArrayList<Film> film_list;	// list of films currently playing in the cinema
	private ArrayList<Projection> past_projections;	// historic list of projection
	private ArrayList<Projection> current_projections;	// list of current projections
	private ArrayList<Customer> customer_list;	// list of customers

	public Cinema()
	{
		this.film_list = new ArrayList<>();
		this.past_projections = new ArrayList<>();
		this.current_projections = new ArrayList<>();
		this.customer_list = new ArrayList<>();
	}

	public ArrayList<Film> getFilmList() {
		sortFilmList();
		return film_list;
	}

	/**
	 * Generate a report that shows each film's total number of spectators
	 * and its average rating
	 * @return String
	 */
	public String getSpectorRatingReport() {
		String report = "****** Odeon Cinema ******\n";
		LocalDate report_date = LocalDate.now();
		report += "Film Spectators and Ratings Report\n";
		report += report_date.toString();
		report += "\n--------------------------------------------------------------\n";
		report += "|  Film                     | Spectators  | Average Rating   |\n";
		report += "--------------------------------------------------------------\n";

		for (Film film : film_list) {
			String film_name = film.getFilmName();
			report += "| " + film_name + "   |  \n";
			String spectator_num = Integer.toString(film.getTotalSpectator());
			report += spectator_num + "   |  \n";
			String avg_rating = Double.toString(film.getAvgRating());
			report += avg_rating + "   |\n";
			report += "--------------------------------------------------------------\n";
		}
		return report;
	}

	/**
	 * Generate a report that shows each film's total number of spectators and its average rating
	 * and save to a file specified in the file name parameter
	 * @param file_name
	 * @return String
	 */
	public String saveSpectorRatingReport(String file_name) {
		String report = "****** Odeon Cinema ******\n";
		LocalDate report_date = LocalDate.now();
		report += "Film Spectators and Ratings Report\n";
		report += report_date.toString();
		report += "\n--------------------------------------------------------------\n";
		report += "|  Film                     | Spectators  | Average Rating   |\n";
		report += "--------------------------------------------------------------\n";

		for (Film film : film_list) {
			String film_name = film.getFilmName();
			report += "| " + film_name + "   |  \n";
			String spectator_num = Integer.toString(film.getTotalSpectator());
			report += spectator_num + "   |  \n";
			String avg_rating = Double.toString(film.getAvgRating());
			report += avg_rating + "   |\n";
			report += "--------------------------------------------------------------\n";
		}
		try (PrintWriter out = new PrintWriter(file_name)) {
			out.println(report);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return report;
	}

	/**
	 * Generate a report that shows the list of films sorted in descending order
	 * by the total income
	 * @return String
	 */
	public String getFilmEarningReport() {
		String report = "****** Odeon Cinema ******\n";
		LocalDate report_date = LocalDate.now();
		report += "Film Income Report\n";
		report += report_date.toString();
		report += "\n--------------------------------------------------------------\n";
		report += "|  Film                               | Total Income         |\n";
		report += "--------------------------------------------------------------\n";

		for (Film film : film_list) {
			String film_name = film.getFilmName();
			report += "| " + film_name + "    |  \n";
			String income = Double.toString(film.getTotalIncome());
			report += income + "     |\n";
			report += "--------------------------------------------------------------\n";
		}
		return report;
	}

	/**
	 * Generate a report that shows the list of films sorted in descending order by the total income
	 * and save to a file specified in the file name parameter
	 * @param file_name
	 * @return String
	 */
	public String saveFilmEarningReport(String file_name) {
		String report = "****** Odeon Cinema ******\n";
		LocalDate report_date = LocalDate.now();
		report += "Film Income Report\n";
		report += report_date.toString();
		report += "\n--------------------------------------------------------------\n";
		report += "|  Film                               | Total Income         |\n";
		report += "--------------------------------------------------------------\n";

		for (Film film : film_list) {
			String film_name = film.getFilmName();
			report += "| " + film_name + "    |  \n";
			String income = Double.toString(film.getTotalIncome());
			report += income + "     |\n";
			report += "--------------------------------------------------------------\n";
		}
		try (PrintWriter out = new PrintWriter(file_name)) {
			out.println(report);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return report;
	}

	/**
	 * Return a list of 5 films with the highest rating
	 * @return:  ArrayList<Film>
	 */
	public ArrayList<Film> getTop5Rated() {
		ArrayList<Film> topFilms = new ArrayList<>();
		for (Film film : film_list) {
			topFilms.add(film);
		}
		topFilms.sort(Comparator.comparing(Film::getAvgRating));
		Collections.reverse(topFilms);
		return new ArrayList<Film>(topFilms.subList(0, 5));
	}

	/**
	 * Return a list of 5 films with the highest income
	 * @return:  ArrayList<Film>
	 */
	public ArrayList<Film> getTop5Earners() {
		ArrayList<Film> topEarners = new ArrayList<>();
		for (Film film : film_list) {
			topEarners.add(film);
		}
		topEarners.sort(Comparator.comparing(Film::getTotalIncome));
		Collections.reverse(topEarners);
		return new ArrayList<Film>(topEarners.subList(0, 5));
	}

	/**
	 * Return a list of projections for date specified by parameter
	 * @param date
	 * @return
	 */
	public ArrayList<Projection> getProjectionOfDate(LocalDate date)
	{
		this.updateProjection();
		ArrayList<Projection> projections = new ArrayList<>();
		if (date.isBefore(LocalDate.now())) {
			// return projections in the past
			for (Projection single : past_projections) {
				if (date.isEqual(single.getProjectionDate())) {
					// add all projections with matching date
					projections.add(single);
				}
			}
		}
		else {
			// return upcoming projections
			for (Projection single : current_projections) {
				if (date.isEqual(single.getProjectionDate())) {
					// add all projections with matching date
					projections.add(single);
				}
			}
		}
		return projections;
	}

	public ArrayList<Projection> getPastProjections() {
		return past_projections;
	}

	public ArrayList<Projection> getCurrentProjections() {
		return current_projections;
	}

	public void addFilm(Film current_film) {
		film_list.add(current_film);
		sortFilmList();
	}

	public void removeFilm(Film current_film) {
		if (film_list.contains(current_film)) {
			film_list.remove(current_film);
		}
	}

	public void addCurrentProjection(Projection projection) {
		if (!LocalDate.now().isAfter(projection.getProjectionDate())) {
			// projection date is upcoming
			current_projections.add(projection);
			sortProjection(current_projections);
		}
		else {
			this.addPastProjection(projection);
		}
	}

	public void removeCurrentProjection(Projection projection) {
		if (current_projections.contains(projection)) {
			current_projections.remove(projection);
			sortProjection(current_projections);
		}
	}

	public void addPastProjection(Projection projection) {
		if (LocalDate.now().isAfter(projection.getProjectionDate())) {
			// projection date is in the past
			past_projections.add(projection);
			sortProjection(past_projections);
		}
		else {
			this.addCurrentProjection(projection);
		}
	}

    /**
     * Update the lists of current and past projections based on date
	 * Today's projections are kept in current projection list
     * @return:  void
     */
	public void updateProjection() {
		LocalDate today = LocalDate.now();
		ArrayList<Projection> upcoming = new ArrayList<>();
		for (Projection playing : current_projections) {
			if (today.isBefore(playing.getProjectionDate()) || today.isEqual(playing.getProjectionDate())) {
				upcoming.add(playing);
			}
			else {
				this.addPastProjection(playing);
			}
		}
		this.current_projections = upcoming;
	}

	/**
	 * Update the list of films based on income
	 */
	public void sortFilmList() {
		film_list.sort(Comparator.comparing(Film::getTotalIncome));
	}

	/**
	 * Set up 4 projections each day between first_date and last_date inclusive
	 * @param film
	 * @param screenID
	 * @param first_date
	 * @param last_date
	 */
	public void setProjectionSchedule(Film film, String screenID, LocalDate first_date, LocalDate last_date)
	{
		if (first_date.isBefore(last_date)) {
			LocalDate date = first_date;
			while (!date.isAfter(last_date)) {
				this.setProjections(film, screenID, date);
				date = date.plusDays(1);	// increment the date
			}
		}
	}

	/**
	 * Set up 4 projections according to the time slots
	 * and add them to Cinema's current projection list
	 * @param:  Film film
	 * @param:  String screenID
	 * @param:  LocalDate projection_date
	 * @return:  void
	 */
	public void setProjections(Film film, String screenID, LocalDate projection_date)
	{
		Projection projection1 = new Projection(LocalDateTime.of(projection_date, Ticket.AFTERNOON_PROJECTION), screenID, film);
		Projection projection2 = new Projection(LocalDateTime.of(projection_date, Ticket.EVENING_PROJECTION), screenID, film);
		Projection projection3 = new Projection(LocalDateTime.of(projection_date, Ticket.NIGHT_EARLY_PROJECTION), screenID, film);
		Projection projection4 = new Projection(LocalDateTime.of(projection_date, Ticket.NIGHT_LATE_PROJECTION), screenID, film);

		this.addCurrentProjection(projection1);
		this.addCurrentProjection(projection2);
		this.addCurrentProjection(projection3);
		this.addCurrentProjection(projection4);
	}

	/**
	 * Append customer to its list
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customer_list.add(customer);
		customer_list.sort(Comparator.comparing(Customer::getSurname));
	}

	/**
	 * Sort the project list in ascending projection date
	 * @param projections
	 */
	private void sortProjection(ArrayList<Projection> projections) {
		projections.sort(Comparator.comparing(Projection::getProjectionDate));
	}

}
