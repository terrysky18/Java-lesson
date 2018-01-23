package com.EirScientific.OdeonCinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer {

    private String christian_name;
    private String surname;
    private String full_name;
    private ArrayList<Ticket> booking_tickets;

    public Customer(String christian_name, String surname) {
        this.christian_name = christian_name;
        this.surname = surname;
        this.full_name = christian_name + surname;
        this.booking_tickets = new ArrayList<Ticket>();
    }

    public Customer(String full_name)
    {
        this.full_name = full_name;
        String[] names = full_name.split("\\s+");
        this.christian_name = names[0];
        this.surname = names[1];
        this.booking_tickets = new ArrayList<Ticket>();
    }

    @Override
    public String toString()
    {
        String customer = this.full_name + "\n";
        customer += "Total ticket #: ";
        customer += Integer.toString(this.booking_tickets.size());
        customer += "\n";
        return  customer;
    }

    public String getFullName() { return this.full_name; }

    public String getSurname() {
        return this.surname;
    }

    public String getChristianName() {
        return this.christian_name;
    }

    /**
     * Purchase a film ticket, the ticket is added to customer purchase history
     * @param: Projection film_showing; specify the film showing which the ticket is for
     * @param: String seatID; specify the seatID
     * @param: int payment_method; 1 for credit card, 2 for cash
     * @param: boolean isVip; indicate if VIP seat is being booked
     * @return:  boolean
     */
    public boolean buyTicket(Projection film_showing, String seatID, int payment_method, boolean isVip)
    {
        Ticket new_ticket = new Ticket(film_showing, isVip);
        new_ticket.setPayment(payment_method);
        if (new_ticket.setSeatID(seatID)) {
            booking_tickets.add(new_ticket);		// add new ticket purchase history
            film_showing.getProjectedFilm().addSpectator();		// add spectator
            film_showing.getProjectedFilm().addIncome(new_ticket.getPrice());	// add ticket price to film income
            System.out.println("Ticket purchase successful");
            return true;
        }
        else {
            System.out.println("Ticket purchase failed");
            return false;
        }
    }

    /**
     * Return the latest ticket in customer's booking history
     */
    public Ticket getLastTicket() {
        return booking_tickets.get(booking_tickets.size()-1);
    }

    /**
     * Return all tickets in customer's booking history
     */
    public ArrayList<Ticket> getAllTickets() {
        return booking_tickets;
    }

    /**
     * Change the date and time of the latest film ticket
     * @param: Projection new projection
     * @param: String new_seatID
     * @return:  boolean; true if change successful, false if change unsuccessful
     */
    public boolean changeLastTicket(Projection new_projection, String new_seatID)
    {
        boolean changed_success = false;
        Ticket current_ticket = this.getLastTicket();

        // only able to change date and time if ticket is unused
        if (!current_ticket.checkIfTicketUsed()) {
            ArrayList<Integer> open_seats = new_projection.getOpenSeats(current_ticket.getIsVipTicket());

            // new seat is available
            if (open_seats.contains(Integer.parseInt(new_seatID))) {
                // Remove last ticket in array
                this.booking_tickets.remove(booking_tickets.size()-1);
                // Reduce film's total income
                current_ticket.getTicketFilm().reduceIncome(current_ticket.getPrice());
				// Reduce film's spectator
				current_ticket.getTicketFilm().removeSpectator();

                int payment = 0;
                if (current_ticket.getPayment().equals("Credit Card"))
                { payment = 1; }
                else { payment = 2; }

                boolean isVip = current_ticket.getIsVipTicket();
                // purchase a new ticket
                this.buyTicket(new_projection, new_seatID, payment, isVip);

                // check new ticket information
                Ticket new_ticket = this.getLastTicket();
                if (new_ticket.getShowingDateTime().isEqual(new_projection.getProjectionDateTime()) &&
                        new_ticket.getSeatID().equals(new_seatID))
                {   // projection date time and seatID match parameters
                    changed_success = true;
                }
            }
            else { System.out.println("Seat unavailable"); }
        }
        else { System.out.println("Ticket has been used."); }

        return changed_success;
    }

    /**
     * After the customer has watched the film, one is able to send review
     * The film is indicated by ticket_index to the ticket array
     * @param: ticket_index, index to the ticket to array to access the film
     * @param: rating
     * @param: review
     * @return: void
     */
    public void sendFilmReview(int ticket_index, int rating, String review)
    {
        if (ticket_index < this.booking_tickets.size()) {
            Ticket ticket = booking_tickets.get(ticket_index);
            if (ticket.checkIfTicketUsed()) {
                // the customer has watched the film
                Film film = ticket.getTicketFilm();
                LocalDateTime review_date_time = LocalDateTime.now();
                FilmReview filmReview = new FilmReview(review_date_time, rating, review);
                film.addCustomerReview(filmReview);
            }
            else {
                System.out.println("Review should be provided after the film has been watched.");
            }
        }
    }

    /**
     * After the customer has watched the latest film, one is able to send
     * @param: rating
     * @param: review
     * @return: void
     */
    public void sendFilmReview(int rating, String review)
    {
        Ticket ticket = booking_tickets.get(booking_tickets.size()-1);
        if (ticket.checkIfTicketUsed()) {
            // the customer has watched the film
            Film film = ticket.getTicketFilm();
            LocalDateTime review_date_time = LocalDateTime.now();
            FilmReview filmReview = new FilmReview(review_date_time, rating, review);
            film.addCustomerReview(filmReview);
        }
        else {
            System.out.println("Review should be provided after the film has been watched.");
        }
    }
}
