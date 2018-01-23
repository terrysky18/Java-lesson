package com.EirScientific.OdeonCinema;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

	private Projection film_projection;
	private String seatID;
    private boolean isVip_ticket;
    private Boolean isTicket_used;
    private double price;
    private int payment;
    private LocalDateTime purchase_date_time;

    public static final int PAY_USING_C_CARD = 1;
    public static final int PAY_USING_CASH = 2;

    // Projection time
    public static final LocalTime AFTERNOON_PROJECTION = LocalTime.of(15, 30);
    public static final LocalTime EVENING_PROJECTION = LocalTime.of(17, 30);
    public static final LocalTime NIGHT_EARLY_PROJECTION = LocalTime.of(19, 0);
    public static final LocalTime NIGHT_LATE_PROJECTION = LocalTime.of(21, 0);

    // VIP seats pricing
    public static final double VIP_AFTERNOON = 16.95;
    public static final double VIP_EVENING = 22;
    public static final double VIP_NIGHT_EARLY = 38;
    public static final double VIP_NIGHT_LATE = 31.98;

    // Normal seats pricing
    public static final double AFTERNOON_SHOW = 7.99;
    public static final double EVENING_SHOW = 12.95;
    public static final double NIGHT_EARLY_SHOW = 27.59;
    public static final double NIGHT_LATE_SHOW = 22.98;

	public Ticket() {
		this.film_projection = null;
		this.seatID = null;
		this.isVip_ticket = false;
		this.isTicket_used = null;
		this.price = 0;
		this.payment = 0;
		this.purchase_date_time = null;
	}

	public Ticket(Projection film_projection, boolean isVip) {
		this.film_projection = film_projection;
		this.seatID = null;
		this.isVip_ticket = isVip;
		this.isTicket_used = null;
		this.price = 0;
		this.payment = 0;
		this.purchase_date_time = LocalDateTime.now();

		this.setTicketPrice();
	}

    /**
     * return Ticket member variables in String
     */
    @Override
    public String toString() {
    	String ticket_info = film_projection.toString();
    	if (isVip_ticket) { ticket_info += "\nVIP seat"; }
    	ticket_info += "\nSeat #: ";
    	ticket_info += this.seatID;
    	ticket_info += "\nPrice: ";
    	ticket_info += Double.toString(this.price);
    	ticket_info += "\nPayment: ";
    	if (payment == PAY_USING_CASH) { ticket_info += "Cash"; }
    	else { ticket_info += "Credit Card"; }

		DateTimeFormatter dt_formatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");
    	String purchase_dt = this.purchase_date_time.format(dt_formatter);
    	ticket_info += "\nPurchase date & time: ";
    	ticket_info += purchase_dt;
    	return ticket_info;
    }

    /**
     * Set seatID based on parameter
     * @param seatID
     * @return  boolean, true if booked successfully, false if unsuccessful
     */
	public boolean setSeatID(String seatID) {
		boolean set_suceed = false;
		int target_seat = Integer.parseInt(seatID);
		set_suceed = this.film_projection.bookOpenSeat(target_seat, isVip_ticket);

		if (set_suceed) { this.seatID = seatID; }
		return set_suceed;
	}

	public void setIsVipTicket(boolean isVIP) { this.isVip_ticket = isVIP; }

    public void setPayment(int payment)
    {
        if (payment == PAY_USING_C_CARD) { this.payment = PAY_USING_C_CARD; }
        else if (payment == PAY_USING_CASH) { this.payment = PAY_USING_CASH; }
    }

    public void setPurchaseDateTime(LocalDateTime purchase_date_time)
    { this.purchase_date_time = purchase_date_time; }

    /**
     * Set the ticket price based on showing time parameter
     * @param  showing_time
     * @return  void
     */
    public void setTicketPrice(LocalTime showing_time)
    {
        if (showing_time.equals(AFTERNOON_PROJECTION))
        {
            this.setPrice(VIP_AFTERNOON, AFTERNOON_SHOW);
        }
        else if (showing_time.equals(EVENING_PROJECTION))
        {
            this.setPrice(VIP_EVENING, EVENING_SHOW);
        }
        else if (showing_time.equals(NIGHT_EARLY_PROJECTION))
        {
            this.setPrice(VIP_NIGHT_EARLY, NIGHT_EARLY_SHOW);
        }
        else
        {
            this.setPrice(VIP_NIGHT_LATE, NIGHT_LATE_SHOW);
        }
    }

    /**
     * Set the ticket price using the member variable film projection's time
     * @return  void
     */
    public void setTicketPrice()
    {
        LocalTime showing_time = this.film_projection.getProjectionTime();
        if (showing_time.equals(AFTERNOON_PROJECTION))
        {
            this.setPrice(VIP_AFTERNOON, AFTERNOON_SHOW);
        }
        else if (showing_time.equals(EVENING_PROJECTION))
        {
            this.setPrice(VIP_EVENING, EVENING_SHOW);
        }
        else if (showing_time.equals(NIGHT_EARLY_PROJECTION))
        {
            this.setPrice(VIP_NIGHT_EARLY, NIGHT_EARLY_SHOW);
        }
        else
        {
            this.setPrice(VIP_NIGHT_LATE, NIGHT_LATE_SHOW);
        }
    }

    public String getPayment()
    {
        if (payment == PAY_USING_C_CARD) { return "Credit Card"; }
        else if (payment == PAY_USING_CASH) { return "Cash"; }
        else { return "Invalid payment"; }
    }

    public boolean getIsVipTicket() { return this.isVip_ticket; }

    public String getSeatID() { return this.seatID; }

    public LocalDateTime getPurchaseDateTime() { return this.purchase_date_time; }

    public LocalDateTime getShowingDateTime() { return film_projection.getProjectionDateTime(); }

    public double getPrice() { return this.price; }

    public Film getTicketFilm() { return this.film_projection.getProjectedFilm(); }

    /**
     * True if ticket is used; false if ticket is unused
     * @return  boolean
     */
    public boolean checkIfTicketUsed()
    {
        LocalDateTime current_date_time = LocalDateTime.now();
        LocalDateTime showing_date_time = film_projection.getProjectionDateTime();
        // check if current time is after the showing time
        this.isTicket_used = current_date_time.isAfter(showing_date_time);
        return isTicket_used;
    }

    /**
     * Private function: set the ticket price based on isVip_ticket
     * @param Vip_ticket
     * @param normal_ticket
     */
    private void setPrice(double Vip_ticket, double normal_ticket)
    {
        if (isVip_ticket) { this.price = Vip_ticket; }
        else { this.price = normal_ticket; }
    }

}
