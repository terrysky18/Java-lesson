package com.EirScientific.OdeonCinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;

public class Projection {

    private LocalDateTime projection_date_time;
    private ArrayList<Boolean> vip_seat_status;
    private ArrayList<Boolean> seat_status;
    private String screenID;
    private boolean fully_booked;
    private Film film;

    public static final int VIP_SEAT_CAPACITY = 10;
    public static final int SEAT_CAPACITY = 40;

    public Projection() {
        this.projection_date_time = null;
        this.vip_seat_status = new ArrayList<Boolean>();
        this.seat_status = new ArrayList<Boolean>();
        this.screenID = null;
        this.fully_booked = false;
        this.film = null;

        // initialise VIP seat stati
        this.resetSeatStati(1);
        // initialise seat stati
        this.resetSeatStati(2);
    }

    public Projection(LocalDateTime projection_date_time, String screenID, Film film) {
        this.projection_date_time = projection_date_time;
        this.vip_seat_status = new ArrayList<Boolean>();
        this.seat_status = new ArrayList<Boolean>();
        this.screenID = screenID;
        this.fully_booked = false;
        this.film = film;

        // initialise VIP seat stati
        this.resetSeatStati(1);
        // initialise seat stati
        this.resetSeatStati(2);
    }

    @Override
    public String toString() {
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("d MMM yyyy");
        DateTimeFormatter time_format = DateTimeFormatter.ofPattern("HH:mm");
        return "Film: " + film.getFilmName() +
                "\nShowing date: " + this.projection_date_time.toLocalDate().format(date_format) +
                "\nShowing time: " + this.projection_date_time.toLocalTime().format(time_format) +
                "\nScreen: " + this.screenID;
    }

    public String getScreenID() { return this.screenID; }

    public LocalDateTime getProjectionDateTime() { return projection_date_time; }

    public LocalDate getProjectionDate() { return projection_date_time.toLocalDate(); }

    public LocalTime getProjectionTime() { return projection_date_time.toLocalTime(); }

    public Film getProjectedFilm() { return this.film; }

    public void setProjectedFilm(Film film) { this.film = film; }

    public void setScreenID(String screenID) { this.screenID = screenID; }

    public void setProjectionDateTime(LocalDate showing_date, LocalTime showing_time) {
    	this.projection_date_time = LocalDateTime.of(showing_date, showing_time);
	}

    public void setProjectionDateTime(LocalDateTime showing_date_time) {
        this.projection_date_time = showing_date_time;
    }

	/**
	 * Return true if fully booked
	 * false if there are open seats
	 * @return  boolean
	 */
	public boolean checkIfFullyBooked() {
        ArrayList<Integer> open_vip = this.getOpenSeats(true);
        ArrayList<Integer> open_seat = this.getOpenSeats(false);
        if (open_vip.size() == 0 && open_seat.size() == 0) {
            fully_booked = true;
        }
        else { fully_booked = false; }
        return fully_booked;
    }

    /**
     * Book a seat specified by seatID if seat is open
     * return true if booking successful
     * return false if booking unsuccessful
     * @param seatID
	 * @param vip_seat
     * @return
     */
    public boolean bookOpenSeat(int seatID, boolean vip_seat) {
        if (vip_seat) {
        	if (seatID >= 0 && seatID < VIP_SEAT_CAPACITY && vip_seat_status.get(seatID)) {
            	vip_seat_status.set(seatID, false);	// make the seat unavailable
            	return true;
        	}
        	else { return false; }
		}
		else {
        	if (seatID >= 0 && seatID < SEAT_CAPACITY && seat_status.get(seatID)) {
            	seat_status.set(seatID, false); // make the seat unavailable
            	return true;
        	}
        	else { return false; }
		}
    }

    /**
     * Get an ArrayList of available seat ID
     * @param  VipSeat; true for vip seats
     * @return open_seats
     */
    public ArrayList<Integer> getOpenSeats(boolean VipSeat) {
        ArrayList<Integer> open_seats = new ArrayList<Integer>();
        if (VipSeat) {
            for (int i=0; i<VIP_SEAT_CAPACITY; i++) {
                if (vip_seat_status.get(i)) { open_seats.add(i); }
            }
        }
        else {
            for (int i=0; i<SEAT_CAPACITY; i++) {
                if (seat_status.get(i)) { open_seats.add(i); }
            }
        }
        return open_seats;
    }

    /**
     * Reset all seats to open
     * @param seat_type; 1 for VIP, 2 for normal seats
     */
    private void resetSeatStati(int seat_type) {
        if (seat_type == 1)
        {
            if (vip_seat_status.size() > 0) {
                ListIterator iter = vip_seat_status.listIterator();
                while (iter.hasNext()) {
                    // set each seat to true for being available
                    iter.set(true);
                }
            }
            else {
                // initialise the vip seat list
                for (int i=0; i<VIP_SEAT_CAPACITY; i++) {
                    // set each set to true for being available
                    vip_seat_status.add(true);
                }
            }
        }
        else
		{
		    if (seat_status.size() > 0) {
                ListIterator iter = seat_status.listIterator();
                while (iter.hasNext()) {
                    // set each seat to true for being available
                    iter.set(true);
                }
            }
            else {
                // initialise the vip seat list
                for (int i=0; i<SEAT_CAPACITY; i++) {
                    // set each set to true for being available
                    seat_status.add(true);
                }
            }
        }
    }

}
