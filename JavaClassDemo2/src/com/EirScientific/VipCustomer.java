package com.EirScientific;

/**
 * Created by Terry Song on 09/07/2017.
 */
public class VipCustomer {

	private String customer_name;
	private double credit_limit;
	private String customer_email1;

	public VipCustomer()
	{
		/* Default constructor */
		/* use default values for initialisation */
		this("default name", 10000.00, "myemail@address.co.uk");
	}

	public VipCustomer(String customer_name, String customer_email)
	{
		/* use default credit limit */
		this(customer_name, 10000.00, customer_email);
	}

	public VipCustomer(String customer_name, double credit_limit, String customer_email)
	{
		this.customer_name = customer_name;
		this.credit_limit = credit_limit;
		this.customer_email1 = customer_email;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public double getCredit_limit() {
		return credit_limit;
	}

	public String getCustomer_email1() {
		return customer_email1;
	}
}
